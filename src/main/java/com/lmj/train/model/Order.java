package com.lmj.train.model;

public class Order {
    /**
     *订单表
     * id:主键，自增类型,唯一标识，int类型，不为空;
     * uid:外键，对应用户表主键，表示该订单属于哪个用户，不为空；
     * rid:外键，对应路线表主键，表示该订单的路线是什么，不为空；
     * payStatus:支付状态，表示订单是否已经付款，int,0为未支付，1表示已支付，不为空；
     *
     * **/
    private Integer id;
    private Integer uid;
    private Integer rid;
    private Integer payStatus;

    public Order() {
    }

    public Order(Integer id, Integer uid, Integer rid, Integer payStatus) {
        this.id = id;
        this.uid = uid;
        this.rid = rid;
        this.payStatus = payStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid=" + uid +
                ", rid=" + rid +
                ", payStatus=" + payStatus +
                '}';
    }
}
