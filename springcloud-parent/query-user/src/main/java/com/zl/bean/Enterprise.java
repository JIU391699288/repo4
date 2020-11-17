package com.zl.bean;

import java.io.Serializable;
import java.util.Date;

public class Enterprise implements Serializable {

    private  Integer ACCOUNTID;
    private  Integer USERID;
    private  String  PWD;
    private  String  NAME;
    private  String IDCARD;
    private  String   PHONE;
    private  Integer  TYPE;
    private  String  ADDRESS;
    private   Date    RTIME;

    @Override
    public String toString() {
        return "Enterprise{" +
                "ACCOUNTID=" + ACCOUNTID +
                ", USERID=" + USERID +
                ", PWD='" + PWD + '\'' +
                ", NAME='" + NAME + '\'' +
                ", IDCARD='" + IDCARD + '\'' +
                ", PHONE='" + PHONE + '\'' +
                ", TYPE=" + TYPE +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", RTIME=" + RTIME +
                '}';
    }

    public Integer getACCOUNTID() {
        return ACCOUNTID;
    }

    public void setACCOUNTID(Integer ACCOUNTID) {
        this.ACCOUNTID = ACCOUNTID;
    }

    public Integer getUSERID() {
        return USERID;
    }

    public void setUSERID(Integer USERID) {
        this.USERID = USERID;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getIDCARD() {
        return IDCARD;
    }

    public void setIDCARD(String IDCARD) {
        this.IDCARD = IDCARD;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public Integer getTYPE() {
        return TYPE;
    }

    public void setTYPE(Integer TYPE) {
        this.TYPE = TYPE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public Date getRTIME() {
        return RTIME;
    }

    public void setRTIME(Date RTIME) {
        this.RTIME = RTIME;
    }

    public Enterprise(Integer ACCOUNTID, Integer USERID, String PWD, String NAME, String IDCARD, String PHONE, Integer TYPE, String ADDRESS, Date RTIME) {

        this.ACCOUNTID = ACCOUNTID;
        this.USERID = USERID;
        this.PWD = PWD;
        this.NAME = NAME;
        this.IDCARD = IDCARD;
        this.PHONE = PHONE;
        this.TYPE = TYPE;
        this.ADDRESS = ADDRESS;
        this.RTIME = RTIME;
    }

    public Enterprise() {

    }
}
