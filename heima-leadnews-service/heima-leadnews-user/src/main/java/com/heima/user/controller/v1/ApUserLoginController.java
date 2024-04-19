package com.heima.user.controller.v1;

import com.heima.model.common.dtos.R;
import com.heima.model.user.dtos.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * App用户登录
 *
 * @author Kang Yong
 * @date 2024/4/19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/login")
public class ApUserLoginController {

    @PostMapping("/login_auth")
    public R login(@RequestBody LoginDto dto) {
        return null;
    }
}
