package com.lmj.train.service;


import com.lmj.train.model.User;


public interface IUserService {
    //注册用户
    void registerUser(User user);
    //根据用户名发现用户
    User findUserByUserName(String username);
    int getUserByName(String username);
    //用户登录
    User loginUser(User user );
}
