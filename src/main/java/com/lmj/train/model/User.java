package com.lmj.train.model;

public class User {
    /**
     *
     *     <!--/**-->
     *     <!--* useraaa(用户)表：-->
     *     <!--* id:主键，自增类型,唯一标识，int类型，不为空-->
     *     <!--* username：用户名，varchar类型，不为空-->
     *     <!--* password:账号密码，varchar类型，不为空-->
     *     <!--* email:youxiang1，varchar类型，不为空-->
     *     <!--* idCard:身份证号，varchar类型，不为空-->
     *     <!--* type:账号类型，int类型，0为管理员，1为普通用户；-->
     *     <!--phoneNums-->
     *
     * **/
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String idCard;
    private Integer type;
    private String phoneNums;

    public User(Integer id, String username, String password, String email, String idCard, Integer type, String phonNums) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.idCard = idCard;
        this.type = type;
        this.phoneNums = phoneNums;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhoneNums() {
        return phoneNums;
    }

    public void setPhoneNums(String phoneNums) {
        this.phoneNums = phoneNums;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", idCard='" + idCard + '\'' +
                ", type=" + type +
                ", phoneNums=" + phoneNums +
                '}';
    }
}
