package com.heima.user.controller.v1;

import com.heima.model.common.dtos.R;
import com.heima.model.user.dtos.LoginDto;
import com.heima.user.service.ApUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * App用户登录
 *
 * @author Kang Yong
 * @date 2024/4/19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/login")
@Api(value = "app端用户登录", tags = "ap_user", description = "app端用户登录API")
public class ApUserLoginController {

    @Autowired
    private ApUserService apUserService;

    @PostMapping("/login_auth")
    @ApiOperation("用户登录")
    public R login(@RequestBody LoginDto dto) {
        return apUserService.login(dto);
    }


    @PostMapping("/addNewUserDemo")
    public R<Void> addNewUserDemo(@RequestParam("name") String name, @RequestParam("pNum") Integer pNum) {
        return apUserService.addNewUserDemo(name, pNum);
    }

    @PostMapping("/addNewUserDemo2")
    public R<Void> addNewUserDemo2(@RequestParam("name") String name, @RequestParam("pNum") Integer pNum) {
        return apUserService.addNewUserDemo2(name, pNum);
    }

}
