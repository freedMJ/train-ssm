package com.lmj.train.service.impl;

import com.lmj.train.mapper.RouteMapper;
import com.lmj.train.model.Station;
import com.lmj.train.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteImpl implements IRouteService {
    @Autowired
    private RouteMapper routeMapper;
    @Override
    //新增站点
    public void addStation(String stationName) {
        routeMapper.addStation(stationName);
    }
    //修改站点
    @Override
    public void updateStation(String stationName) {
        routeMapper.updateStation(stationName);
    }
    //删除站点
    @Override
    public void deleteStation(String stationName) {
        routeMapper.deleteStation(stationName);
    }
    //根据名称查找站点
    @Override
    public Station findStationByName(String stationName) {
        return routeMapper.findStationByName(stationName);
    }
}
