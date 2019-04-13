package com.lmj.train.mapper;

import com.lmj.train.model.Station;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteMapper {

    //新增站点
    void addStation(String stationName);
    //修改站点
    void updateStation(@Param("stationName") String stationName,@Param("id")int id);
    //删除站点
    void deleteStation(int id);
    //查找站点
    Station findStationByName(String stationName);
    //分页查询站点
    List<Station> findStatinByPageHepler();
    //根据id查找站点
    Station findStationNameById(int id);
}
