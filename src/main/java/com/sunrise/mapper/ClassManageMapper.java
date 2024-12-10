package com.sunrise.mapper;

import com.sunrise.domain.classmanage.ClassManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassManageMapper {
    ClassManage selectById(Integer belongId);

    List<ClassManage> selectList(ClassManage classManage);

    void addClassManage(ClassManage classManage);

    void updateById(ClassManage classManage);
}
