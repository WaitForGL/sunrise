package com.sunrise.service;

import com.sunrise.domain.classmanage.ClassManage;

public interface ClassManageService {
    ClassManage selectById(Integer belongId);
}
