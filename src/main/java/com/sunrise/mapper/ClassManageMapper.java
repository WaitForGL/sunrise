package com.sunrise.mapper;

import com.sunrise.domain.classmanage.ClassManage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassManageMapper {
    ClassManage selectById(Integer belongId);
}
