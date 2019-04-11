package com.lmj.train.service;

import com.lmj.train.model.Station;

public interface IRouteService {

    //新增站点
    void addStation(String stationName);
    //修改站点
    void updateStation(String stationName);
    //删除站点
    void deleteStation(String stationName);
    //查找站点
    Station findStationByName(String stationName);

}
