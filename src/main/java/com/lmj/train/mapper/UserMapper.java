package com.lmj.train.mapper;

import com.lmj.train.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    //注册用户
    void registerUser(User user);
    //根据用户名发现用户
    User findUserByUserName(String username);
    int getUserByName(String username);
    //用户登录
    User loginUser(User user);
}
