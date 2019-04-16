package com.lmj.train.model.pojo;

public class OrderInfo {
    private int rid;
    private String trainName;
    private String startPoint;
    private String endPoint;
    private Long startTime;
    private Long endTime;
    private  int placeType;
    private float price;

    public OrderInfo() {
    }

    public OrderInfo(int rid, String trainName, String startPoint, String endPoint, Long startTime, Long endTime, int placeType, float price) {
        this.rid = rid;
        this.trainName = trainName;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startTime = startTime;
        this.endTime = endTime;
        this.placeType = placeType;
        this.price = price;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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

    public int getPlaceType() {
        return placeType;
    }

    public void setPlaceType(int placeType) {
        this.placeType = placeType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "rid=" + rid +
                ", trainName='" + trainName + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", placeType=" + placeType +
                ", price=" + price +
                '}';
    }
}
