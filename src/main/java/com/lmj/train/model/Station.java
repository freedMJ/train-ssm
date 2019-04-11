package com.lmj.train.model;

public class Station {

    /**
     *
     *station（站点表）
     * id 主键
     * stationName 站点名
     * **/
    private Integer id;
    private String stationName;

    public Station() {
    }

    public Station(Integer id, String stationName) {
        this.id = id;
        this.stationName = stationName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
