package com.sunrise.service;

import com.sunrise.domain.classmanage.ClassManage;
import com.sunrise.domain.user.User;

import java.util.List;

public interface ClassManageService {
    ClassManage selectById(Integer belongId);

    List<ClassManage> selectList(ClassManage classManage);

    void addClassManage(ClassManage classManage);

    void updateById(ClassManage classManage);

    List<User> detail(ClassManage classManage);
}
