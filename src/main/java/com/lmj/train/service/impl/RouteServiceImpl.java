package com.lmj.train.service.impl;

import com.lmj.train.mapper.RouteMapper;
import com.lmj.train.model.Price;
import com.lmj.train.model.Route;
import com.lmj.train.model.pojo.RouteInfo;
import com.lmj.train.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements IRouteService {
    @Autowired
    private RouteMapper routeMapper;

    //保存路线信息
    @Override
    public void saveRoute(Route route) {
        routeMapper.saveRoute(route);
    }

    //根据车次名查找路线id
    @Override
    public int findRoutebyId(String trainName) {
        return routeMapper.findRoutebyId(trainName);
    }

    //保存价格信息
    @Override
    public void savePrice(Price price) {
        routeMapper.savePrice(price);
    }

    //查询所有路线
    @Override
    public List<Route> findAllRoute() {
        return routeMapper.findAllRoute();
    }
    //查询抵达时间小于某段时间内的路线
    @Override
    public List<Route> findAllRouteByLessTime(Long time,Long currentTime) {
        return routeMapper.findAllRouteByLessTime(time, currentTime);
    }

    //根据id删除路线
    @Override
    public void deleteRouteById(int id) {
        routeMapper.deleteRouteById(id);
    }

    //根据id删除价格
    @Override
    public void deletePriceByRid(int rid) {
        routeMapper.deletePriceByRid(rid);
    }

    //根据id 查找路线
    @Override
    public Route findRouteById(int id) {
        return routeMapper.findRouteById(id);
    }

    //根据id 查找价格
    @Override
    public Price findPriceById(int rid) {
        return routeMapper.findPriceById(rid);
    }
    //根据id 查找routeInfo的信息
    @Override
    public RouteInfo findRouteInfoById(int id) {
        return routeMapper.findRouteInfoById(id);
    }
    //更新车次信息
    @Override
    public void updateRouteInfo(RouteInfo routeInfo) {
        routeMapper.updateRouteInfo(routeInfo);
    }
    //根据车次名查id
    @Override
    public int findIdByTrainName(String trainName) {
        return routeMapper.findIdByTrainName(trainName);
    }
    //根据id查车次
    @Override
    public String findTrainNameById(int id) {
        return routeMapper.findTrainNameById(id);
    }
    //查询所有未发车的列车
    @Override
    public List<RouteInfo> findAllNotStartTrain(Long time) {
        return routeMapper.findAllNotStartTrain(time);
    }
    //路线表卧铺减一


    @Override
    public void routeSleepBerthNumsLessOne(int id) {
        routeMapper.routeSleepBerthNumsLessOne(id);
    }
    //路线表硬座减一
    @Override
    public void routeSeatNumsLessOne(int id) {
            routeMapper.routeSeatNumsLessOne(id);
    }
    //路线表站票减一
    @Override
    public void routeStandNumsLessOne(int id) {
        routeMapper.routeStandNumsLessOne(id);
    }

}
