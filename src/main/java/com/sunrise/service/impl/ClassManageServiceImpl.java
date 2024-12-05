package com.sunrise.service.impl;

import com.sunrise.domain.classmanage.ClassManage;
import com.sunrise.mapper.ClassManageMapper;
import com.sunrise.service.ClassManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClassManageServiceImpl implements ClassManageService {

    @Resource
    private ClassManageMapper classManageMapper;

    @Override
    public ClassManage selectById(Integer belongId) {
        return classManageMapper.selectById(belongId);
    }
}
