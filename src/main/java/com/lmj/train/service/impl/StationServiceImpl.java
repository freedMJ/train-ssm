package com.lmj.train.service.impl;

import com.lmj.train.mapper.StationMapper;
import com.lmj.train.model.Station;
import com.lmj.train.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements IStationService {
    @Autowired
    private StationMapper stationMapper;
    @Override
    //新增站点
    public void addStation(String stationName) {
        stationMapper.addStation(stationName);
    }
    //修改站点
    @Override
    public void updateStation(String stationName,int id) {
        stationMapper.updateStation(stationName,id);
    }
    //删除站点
    @Override
    public void deleteStation(int id) {
        stationMapper.deleteStation(id);
    }
    //根据名称查找站点
    @Override
    public Station findStationByName(String stationName) {
        return stationMapper.findStationByName(stationName);
    }
    //分页查询站点
    @Override
    public List<Station> findStatinByPageHepler() {
        return stationMapper.findStatinByPageHepler();
    }
    //根据id查找站点名
    @Override
    public Station findStationNameById(int id) {
        return stationMapper.findStationNameById(id);
    }
    //查找所有的站点
    @Override
    public  List<Station> findAllStation() {
        return stationMapper.findAllStation();
    }
}
