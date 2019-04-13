package com.lmj.train.service.impl;

import com.lmj.train.mapper.RouteMapper;
import com.lmj.train.model.Station;
import com.lmj.train.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void updateStation(String stationName,int id) {
        routeMapper.updateStation(stationName,id);
    }
    //删除站点
    @Override
    public void deleteStation(int id) {
        routeMapper.deleteStation(id);
    }
    //根据名称查找站点
    @Override
    public Station findStationByName(String stationName) {
        return routeMapper.findStationByName(stationName);
    }
    //分页查询站点
    @Override
    public List<Station> findStatinByPageHepler() {
        return routeMapper.findStatinByPageHepler();
    }
    //根据id查找站点名
    @Override
    public Station findStationNameById(int id) {
        return routeMapper.findStationNameById(id);
    }
}
