package com.lmj.train.model;

public class Route {
    /**
     * 路线表
     * id:主键，自增类型,唯一标识，int类型，不为空；
     * trainNums:车次信息；jd134da1,string
     * startPoint:起始站，varchar类型，不为空；
     * endPoint:终点站，varchar类型，不为空
     * startTime:发车时间，timestamp类型，不为空；
     * endTime:抵达时间，timestamp类型，不为空；
     * trainType:火车类型，int类型，0为高铁，1为普通列车；
     * sleepBerthNums:卧铺数
     * seatNums:硬座
     * standNums:站票
     * */
    private Integer id;
    private String trainName;
    private String startPoint;
    private String endPoint;
    private Long startTime;
    private Long endTime;
    private Integer trainType;
    private Integer sleepBerthNums;
    private Integer seatNums;
    private Integer standNums;

    public Route() {
    }

    public Route(Integer id, String trainName, String startPoint, String endPoint, Long startTime, Long endTime, Integer trainType, Integer sleepBerthNums, Integer seatNums, Integer standNums) {
        this.id = id;
        this.trainName = trainName;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startTime = startTime;
        this.endTime = endTime;
        this.trainType = trainType;
        this.sleepBerthNums = sleepBerthNums;
        this.seatNums = seatNums;
        this.standNums = standNums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getTrainType() {
        return trainType;
    }

    public void setTrainType(Integer trainType) {
        this.trainType = trainType;
    }

    public Integer getSleepBerthNums() {
        return sleepBerthNums;
    }

    public void setSleepBerthNums(Integer sleepBerthNums) {
        this.sleepBerthNums = sleepBerthNums;
    }

    public Integer getSeatNums() {
        return seatNums;
    }

    public void setSeatNums(Integer seatNums) {
        this.seatNums = seatNums;
    }

    public Integer getStandNums() {
        return standNums;
    }

    public void setStandNums(Integer standNums) {
        this.standNums = standNums;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", trainName='" + trainName + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", trainType=" + trainType +
                ", sleepBerthNums=" + sleepBerthNums +
                ", seatNums=" + seatNums +
                ", standNums=" + standNums +
                '}';
    }
}
