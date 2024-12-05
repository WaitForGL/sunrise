package com.sunrise.service;

import com.sunrise.domain.user.User;

import java.util.List;

public interface UserService {
    User selectIsExist(User user);

    List<User> selectList(User user);

    void addUser(User user);

    void updateById(User user);
}
