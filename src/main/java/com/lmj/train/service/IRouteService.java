package com.lmj.train.service;

import com.lmj.train.model.Station;

import java.util.List;

public interface IRouteService {

    //新增站点
    void addStation(String stationName);
    //修改站点
    void updateStation(String stationName,int id);
    //删除站点
    void deleteStation(int id);
    //查找站点
    Station findStationByName(String stationName);
    //分页查询站点
    List<Station> findStatinByPageHepler();
    //根据id查找站点
    Station findStationNameById(int id);


}
