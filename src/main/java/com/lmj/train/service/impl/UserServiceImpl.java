package com.lmj.train.service.impl;

import com.lmj.train.mapper.UserMapper;
import com.lmj.train.model.User;
import com.lmj.train.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void registerUser(User user) {
        userMapper.registerUser(user);

    }

    @Override
    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

    @Override
    public int getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public User loginUser(User user) {
        return userMapper.loginUser(user);
    }
}
