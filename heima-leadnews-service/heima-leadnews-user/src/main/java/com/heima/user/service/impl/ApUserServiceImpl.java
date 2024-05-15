package com.heima.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.R;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dtos.LoginDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;
import com.heima.utils.common.AppJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * @author kangy
 * @description 针对表【ap_user(APP用户信息表)】的数据库操作Service实现
 * @createDate 2024-05-09 15:42:36
 */
@Slf4j
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

    @Override
    public R addNewUserDemo(String name, Integer pNum) {
        log.info("ApUserServiceImpl[addNewUserDemo]===START==={}", System.currentTimeMillis());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < pNum; i++) {
            CompletableFuture<Void> future = saveNewUser(name, i);
            futures.add(future);
        }
        log.info("ApUserServiceImpl[addNewUserDemo]===END==={}", System.currentTimeMillis());
        return R.okResult();
    }

    @Override
    public R<Void> addNewUserDemo2(String name, Integer pNum) {
        log.info("ApUserServiceImpl[addNewUserDemo]===START==={}", System.currentTimeMillis());

        for (int i = 0; i < pNum; i++) {
            ApUser user = new ApUser();

            user.setSalt(name + i);
            user.setName(name + i);
            user.setPassword(name + i);
            user.setPhone(name + i);
            user.setImage(name + i);
            user.setCreatedTime(new Date());

            this.save(user);
            log.info("ApUserServiceImpl[saveNewUser]:保存用户成功{}", JSON.toJSONString(user));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("ApUserServiceImpl[addNewUserDemo]===END==={}", System.currentTimeMillis());
        return R.okResult();
    }

    private CompletableFuture<Void> saveNewUser(String name, int i) {
        return CompletableFuture.runAsync(() -> {
            ApUser user = new ApUser();

            user.setSalt(name + i);
            user.setName(name + i);
            user.setPassword(name + i);
            user.setPhone(name + i);
            user.setImage(name + i);
            user.setCreatedTime(new Date());

            this.save(user);
            log.info("ApUserServiceImpl[saveNewUser]:异步保存用户成功{}", JSON.toJSONString(user));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}




