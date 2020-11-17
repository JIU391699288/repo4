package com.zl.bean;

import java.io.Serializable;

public class Person implements Serializable {
    private  Integer USER_ID;
    private  String USER_NAME;
    private  String USER_PWD;
    private  String  USER_TEL;
    private  Integer USER_TYPE;
    private  String USER_TYPESTR;

    public String getUSER_TYPESTR() {

        return USER_TYPESTR;
    }

    public void setUSER_TYPESTR(String USER_TYPESTR) {
        if (USER_TYPESTR=="个人用户"){
            USER_TYPE=0;
        }else {
            USER_TYPE=1;
        }
        this.USER_TYPESTR = USER_TYPESTR;
    }

    @Override
    public String toString() {
        return "Person{" +
                "USER_ID=" + USER_ID +
                ", USER_NAME='" + USER_NAME + '\'' +
                ", USER_PWD='" + USER_PWD + '\'' +
                ", USER_TEL='" + USER_TEL + '\'' +
                ", USER_TYPE=" + USER_TYPE +
                '}';
    }

    public Person(Integer USER_ID, String USER_NAME, String USER_PWD, String USER_TEL, Integer USER_TYPE) {
        this.USER_ID = USER_ID;
        this.USER_NAME = USER_NAME;
        this.USER_PWD = USER_PWD;
        this.USER_TEL = USER_TEL;
        this.USER_TYPE = USER_TYPE;
    }

    public Integer getUSER_ID() {

        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PWD() {
        return USER_PWD;
    }

    public void setUSER_PWD(String USER_PWD) {
        this.USER_PWD = USER_PWD;
    }

    public String getUSER_TEL() {
        return USER_TEL;
    }

    public void setUSER_TEL(String USER_TEL) {
        this.USER_TEL = USER_TEL;
    }

    public Integer getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(Integer USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }

    public Person() {

    }
}
