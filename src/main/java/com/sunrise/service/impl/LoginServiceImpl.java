package com.sunrise.service.impl;

import com.sunrise.mapper.LoginMapper;
import com.sunrise.service.LoginService;

import javax.annotation.Resource;

public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;
}
