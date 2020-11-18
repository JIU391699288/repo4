package com.zl.utils.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Personalaccount implements Serializable {
    private Integer pid;
    private Integer userid;
    private String pwd;
    private String name;
    private String idcard;
    private String phone;
    private Integer state;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registrationtim;
    private String address;

    @Override
    public String toString() {
        return "Personalaccount{" +
                "pid=" + pid +
                ", userid=" + userid +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", registrationtim=" + registrationtim +
                ", address='" + address + '\'' +
                '}';
    }

    public Personalaccount() {
    }

    public Personalaccount(Integer pid, Integer userid, String pwd, String name, String idcard, String phone, Integer state, String sex, Date birthday, Date registrationtim, String address) {

        this.pid = pid;
        this.userid = userid;
        this.pwd = pwd;
        this.name = name;
        this.idcard = idcard;
        this.phone = phone;
        this.state = state;
        this.sex = sex;
        this.birthday = birthday;
        this.registrationtim = registrationtim;
        this.address = address;
    }

    public Integer getPid() {

        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistrationtim() {
        return registrationtim;
    }

    public void setRegistrationtim(Date registrationtim) {
        this.registrationtim = registrationtim;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
