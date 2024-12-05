package com.sunrise.controller;


import com.sunrise.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;
}
