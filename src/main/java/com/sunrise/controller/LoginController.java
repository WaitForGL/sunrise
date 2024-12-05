package com.sunrise.controller;


import cn.hutool.core.util.ObjectUtil;
import com.sunrise.common.AjaxResult;
import com.sunrise.domain.user.User;
import com.sunrise.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;


    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user){
        User isExist = userService.selectIsExist(user);
        if(ObjectUtil.isNotNull(isExist)){
            return AjaxResult.success("登录成功",isExist);
        }
        return AjaxResult.error("用户不存在");
    }

}
