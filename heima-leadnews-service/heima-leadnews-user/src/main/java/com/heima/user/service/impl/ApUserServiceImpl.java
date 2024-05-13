package com.heima.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.R;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dtos.LoginDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;
import com.heima.utils.common.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Handler;

/**
 * @author kangy
 * @description 针对表【ap_user(APP用户信息表)】的数据库操作Service实现
 * @createDate 2024-05-09 15:42:36
 */
@Service
public class ApUserServiceImpl extends ServiceImpl<ApUserMapper, ApUser>
        implements ApUserService {

    @Override
    public R login(LoginDto dto) {
        // 正常登录（手机号+密码）
        if (StringUtils.isNotBlank(dto.getPhone()) && StringUtils.isNotBlank(dto.getPassword())) {
            // 查询用户
            ApUser apUser = this.getOne(Wrappers.<ApUser>lambdaQuery()
                    .eq(ApUser::getPhone, dto.getPhone())
            );
            if (Objects.isNull(apUser)) {
                return R.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "用户不存在");
            }

            // 比对密码
            String salt = apUser.getSalt();
            String pwd = dto.getPassword();
            pwd = DigestUtils.md5DigestAsHex((pwd + salt).getBytes());
            if (!pwd.equals(apUser.getPassword())) {
                return R.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }

            // 返回数据jwt
            Map<String, Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(apUser.getId().longValue()));
            apUser.setSalt(null);
            apUser.setPassword(null);
            map.put("user", apUser);
            return R.okResult(map);
        } else {
            // 游客 同样返回token id=0
            Map<String, Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0L));
            return R.okResult(map);
        }
    }
}




