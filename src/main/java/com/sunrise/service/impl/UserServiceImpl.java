package com.sunrise.service.impl;

import com.sunrise.domain.user.User;
import com.sunrise.mapper.UserMapper;
import com.sunrise.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectIsExist(User user) {
        return userMapper.selectIsExist(user);
    }

    @Override
    public List<User> selectList(User user) {
        return userMapper.selectList(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }
}
