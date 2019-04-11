package com.lmj.train.model;

public class Price {
    /**
     *价格表
     * id:主键，自增类型,唯一标识，int类型，不为空;
     * sleepBerthPrice:卧票价格
     * seatPrice:坐票价格
     * standPrice：站票价格
     * rid:外键，关联route主键，表示路线的价格
     * **/
    private Integer id;
    private Integer sleepBerthPrice;
    private Integer seatPrice;
    private Integer standPrice;
    private Integer rid;

    public Price() {
    }

    public Price(Integer id, Integer sleepBerthPrice, Integer seatPrice, Integer standPrice, Integer rid) {
        this.id = id;
        this.sleepBerthPrice = sleepBerthPrice;
        this.seatPrice = seatPrice;
        this.standPrice = standPrice;
        this.rid = rid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSleepBerthPrice() {
        return sleepBerthPrice;
    }

    public void setSleepBerthPrice(Integer sleepBerthPrice) {
        this.sleepBerthPrice = sleepBerthPrice;
    }

    public Integer getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(Integer seatPrice) {
        this.seatPrice = seatPrice;
    }

    public Integer getStandPrice() {
        return standPrice;
    }

    public void setStandPrice(Integer standPrice) {
        this.standPrice = standPrice;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", sleepBerthPrice=" + sleepBerthPrice +
                ", seatPrice=" + seatPrice +
                ", standPrice=" + standPrice +
                ", rid=" + rid +
                '}';
    }
}
