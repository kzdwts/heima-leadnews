package com.heima.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.user.pojos.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;
import org.springframework.stereotype.Service;

/**
* @author kangy
* @description 针对表【ap_user(APP用户信息表)】的数据库操作Service实现
* @createDate 2024-05-09 15:42:36
*/
@Service
public class ApUserServiceImpl extends ServiceImpl<ApUserMapper, ApUser>
    implements ApUserService {

}




