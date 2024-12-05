package com.sunrise.controller;

import com.sunrise.service.ClassManageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/class")
public class ClassManageController {

    @Resource
    private ClassManageService classManageService;
}
