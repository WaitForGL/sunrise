package com.sunrise.service.impl;

import com.sunrise.domain.classmanage.ClassManage;
import com.sunrise.domain.user.User;
import com.sunrise.mapper.ClassManageMapper;
import com.sunrise.mapper.UserMapper;
import com.sunrise.service.ClassManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassManageServiceImpl implements ClassManageService {

    @Resource
    private ClassManageMapper classManageMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public ClassManage selectById(Integer belongId) {
        return classManageMapper.selectById(belongId);
    }

    @Override
    public List<ClassManage> selectList(ClassManage classManage) {
        return classManageMapper.selectList(classManage);
    }

    @Override
    public void addClassManage(ClassManage classManage) {
         classManageMapper.addClassManage(classManage);
    }

    @Override
    public void updateById(ClassManage classManage) {
        classManageMapper.updateById(classManage);
    }

    @Override
    public List<User> detail(ClassManage classManage) {
        List<User> list = userMapper.selectByClassId(classManage);
        return list;
    }
}
