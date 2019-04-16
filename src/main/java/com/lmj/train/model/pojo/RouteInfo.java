package com.lmj.train.model.pojo;

public class RouteInfo {
    /** trainName:车次信息；jd134da1,string
     * startPoint:起始站，varchar类型，不为空；
            * endPoint:终点站，varchar类型，不为空
     * startTime:发车时间，timestamp类型，不为空；
            * endTime:抵达时间，timestamp类型，不为空；
            * trainType:火车类型，int类型，0为高铁，1为普通列车；
            * sleepBerthNums:卧铺数
     * seatNums:硬座
     * standNums:站票
     * * sleepBerthPrice:卧票价格
     *      * seatPrice:坐票价格
     *      * standPrice：站票价格
     * */
    private int id;
    private String trainName;
    private String startPoint;
    private String endPoint;
    private Long startTime;
    private Long endTime;
    private int trainType;
    private int sleepBerthNums;
    private int seatNums;
    private int standNums;
    private float sleepBerthPrice;
    private float seatPrice;
    private float standPrice;

    public RouteInfo() {
    }

    public RouteInfo(int id, String trainName, String startPoint, String endPoint, Long startTime, Long endTime, int trainType, int sleepBerthNums, int seatNums, int standNums, float sleepBerthPrice, float seatPrice, float standPrice) {
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
        this.sleepBerthPrice = sleepBerthPrice;
        this.seatPrice = seatPrice;
        this.standPrice = standPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getTrainType() {
        return trainType;
    }

    public void setTrainType(int trainType) {
        this.trainType = trainType;
    }

    public int getSleepBerthNums() {
        return sleepBerthNums;
    }

    public void setSleepBerthNums(int sleepBerthNums) {
        this.sleepBerthNums = sleepBerthNums;
    }

    public int getSeatNums() {
        return seatNums;
    }

    public void setSeatNums(int seatNums) {
        this.seatNums = seatNums;
    }

    public int getStandNums() {
        return standNums;
    }

    public void setStandNums(int standNums) {
        this.standNums = standNums;
    }

    public float getSleepBerthPrice() {
        return sleepBerthPrice;
    }

    public void setSleepBerthPrice(float sleepBerthPrice) {
        this.sleepBerthPrice = sleepBerthPrice;
    }

    public float getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(float seatPrice) {
        this.seatPrice = seatPrice;
    }

    public float getStandPrice() {
        return standPrice;
    }

    public void setStandPrice(float standPrice) {
        this.standPrice = standPrice;
    }

    @Override
    public String toString() {
        return "RouteInfo{" +
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
                ", sleepBerthPrice=" + sleepBerthPrice +
                ", seatPrice=" + seatPrice +
                ", standPrice=" + standPrice +
                '}';
    }
}
