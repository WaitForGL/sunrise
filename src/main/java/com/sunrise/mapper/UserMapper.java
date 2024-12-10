package com.sunrise.mapper;

import com.sunrise.domain.classmanage.ClassManage;
import com.sunrise.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectIsExist(User user);

    List<User> selectList(User user);

    void addUser(User user);

    void updateById(User user);

    List<User> selectByClassId(ClassManage classManage);

    User selectById(Long stuId);
}
