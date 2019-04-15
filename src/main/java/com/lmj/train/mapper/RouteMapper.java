package com.lmj.train.mapper;

import com.lmj.train.model.Price;
import com.lmj.train.model.Route;
import com.lmj.train.model.RouteInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteMapper {
    //保存路线信息
    void saveRoute(Route route);
    //根据车次查找路线id
    int findRoutebyId(String trainName);
    //保存价格信息
    void savePrice(Price price);
    //查询所有路线
    List<Route> findAllRoute();
    //查询抵达时间小于某段时间内的路线
    List<Route> findAllRouteByLessTime(@Param("time") Long time,@Param("currentTime")Long currentTime);
    //根据id删除路线
    void deleteRouteById(int id);
    //根据id删除价格
    void deletePriceByRid(int rid);
    //根据id查找route
    Route findRouteById(int id);
    //根据id查找price
    Price findPriceById(int rid);
    //根据id查找routeInfo信息
    RouteInfo findRouteInfoById(int id);
    //跟新路线信息
    void updateRouteInfo(RouteInfo routeInfo);
    //根据车次名查id
    int findIdByTrainName(String trainName);
    //根据id查车次
    String findTrainNameById(int id);
    //查询所有未发车的列车
    List<RouteInfo> findAllNotStartTrain(Long time);
    //查询路线订单信息，根据路线id

}
