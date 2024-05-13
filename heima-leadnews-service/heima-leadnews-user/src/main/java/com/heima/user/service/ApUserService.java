package com.heima.user.service;

import com.heima.model.common.dtos.R;
import com.heima.model.user.dtos.LoginDto;
import com.heima.model.user.pojos.ApUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author kangy
 * @description 针对表【ap_user(APP用户信息表)】的数据库操作Service
 * @createDate 2024-05-09 15:42:36
 */
public interface ApUserService extends IService<ApUser> {

    /**
     * 登录
     *
     * @param dto {@link LoginDto}
     * @return {@link R}
     * @author Kang Yong
     * @date 2024/5/14
     */
    R login(LoginDto dto);
}
