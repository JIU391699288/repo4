package com.zl.bean;

import java.io.Serializable;
import java.util.Date;

public class PersonAccount implements Serializable {
   private Integer id ;
   private Integer userid ;
   private String pwd ;
   private String name ;
   private String idcard ;
   private String phone ;
   private  Integer state ;
   private String sex ;
   private Date birthday;
   private Date openingtime;
   private String  bankdeposit;

    @Override
    public String toString() {
        return "PersonAccount{" +
                "id=" + id +
                ", userid=" + userid +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", openingtime=" + openingtime +
                ", bankdeposit='" + bankdeposit + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getOpeningtime() {
        return openingtime;
    }

    public void setOpeningtime(Date openingtime) {
        this.openingtime = openingtime;
    }

    public String getBankdeposit() {
        return bankdeposit;
    }

    public void setBankdeposit(String bankdeposit) {
        this.bankdeposit = bankdeposit;
    }

    public PersonAccount(Integer id, Integer userid, String pwd, String name, String idcard, String phone, Integer state, String sex, Date birthday, Date openingtime, String bankdeposit) {

        this.id = id;
        this.userid = userid;
        this.pwd = pwd;
        this.name = name;
        this.idcard = idcard;
        this.phone = phone;
        this.state = state;
        this.sex = sex;
        this.birthday = birthday;
        this.openingtime = openingtime;
        this.bankdeposit = bankdeposit;
    }

    public PersonAccount() {

    }
}
