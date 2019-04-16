package com.lmj.train.mapper;

import com.lmj.train.model.Order;
import com.lmj.train.model.Orders;
import com.lmj.train.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //注册用户
    void registerUser(User user);
    //根据用户名发现用户
    User findUserByUserName(String username);
    int getUserByName(String username);
    //用户登录
    User loginUser(User user);
    //存订单信息
    void saveOrderInfo(Orders order);
    //根据uid,rid查找订单
    Orders findOrderByUidAndRid(@Param("uid") int uid, @Param("rid") int rid);
    //根据uid查找订单
    List<Orders> findOrderByUid(int uid);



}
