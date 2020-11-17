package com.zl.bean;

import java.io.Serializable;
import java.util.Date;

public class Bankcard implements Serializable {
   private Integer BC_ID;
   private Integer FK_ACCOUNT_ID;
   private String BC_NUMBER;
   private Integer BC_MONEY;
   private Integer BC_STATES;
   private String BC_PWD;
   private Date BC_DATE;
   private String BC_ADDRESS;
   private String FK_BC_CURRENCY;
   private Integer BC_QUOTA;
    private Integer FK_BC_BANK;

    @Override
    public String toString() {
        return "Bankcard{" +
                "BC_ID=" + BC_ID +
                ", FK_ACCOUNT_ID=" + FK_ACCOUNT_ID +
                ", BC_NUMBER='" + BC_NUMBER + '\'' +
                ", BC_MONEY=" + BC_MONEY +
                ", BC_STATES=" + BC_STATES +
                ", BC_PWD='" + BC_PWD + '\'' +
                ", BC_DATE=" + BC_DATE +
                ", BC_ADDRESS='" + BC_ADDRESS + '\'' +
                ", FK_BC_CURRENCY='" + FK_BC_CURRENCY + '\'' +
                ", BC_QUOTA=" + BC_QUOTA +
                ", FK_BC_BANK=" + FK_BC_BANK +
                '}';
    }

    public Integer getBC_ID() {
        return BC_ID;
    }

    public void setBC_ID(Integer BC_ID) {
        this.BC_ID = BC_ID;
    }

    public Integer getFK_ACCOUNT_ID() {
        return FK_ACCOUNT_ID;
    }

    public void setFK_ACCOUNT_ID(Integer FK_ACCOUNT_ID) {
        this.FK_ACCOUNT_ID = FK_ACCOUNT_ID;
    }

    public String getBC_NUMBER() {
        return BC_NUMBER;
    }

    public void setBC_NUMBER(String BC_NUMBER) {
        this.BC_NUMBER = BC_NUMBER;
    }

    public Integer getBC_MONEY() {
        return BC_MONEY;
    }

    public void setBC_MONEY(Integer BC_MONEY) {
        this.BC_MONEY = BC_MONEY;
    }

    public Integer getBC_STATES() {
        return BC_STATES;
    }

    public void setBC_STATES(Integer BC_STATES) {
        this.BC_STATES = BC_STATES;
    }

    public String getBC_PWD() {
        return BC_PWD;
    }

    public void setBC_PWD(String BC_PWD) {
        this.BC_PWD = BC_PWD;
    }

    public Date getBC_DATE() {
        return BC_DATE;
    }

    public void setBC_DATE(Date BC_DATE) {
        this.BC_DATE = BC_DATE;
    }

    public String getBC_ADDRESS() {
        return BC_ADDRESS;
    }

    public void setBC_ADDRESS(String BC_ADDRESS) {
        this.BC_ADDRESS = BC_ADDRESS;
    }

    public String getFK_BC_CURRENCY() {
        return FK_BC_CURRENCY;
    }

    public void setFK_BC_CURRENCY(String FK_BC_CURRENCY) {
        this.FK_BC_CURRENCY = FK_BC_CURRENCY;
    }

    public Integer getBC_QUOTA() {
        return BC_QUOTA;
    }

    public void setBC_QUOTA(Integer BC_QUOTA) {
        this.BC_QUOTA = BC_QUOTA;
    }

    public Integer getFK_BC_BANK() {
        return FK_BC_BANK;
    }

    public void setFK_BC_BANK(Integer FK_BC_BANK) {
        this.FK_BC_BANK = FK_BC_BANK;
    }

    public Bankcard(Integer BC_ID, Integer FK_ACCOUNT_ID, String BC_NUMBER, Integer BC_MONEY, Integer BC_STATES, String BC_PWD, Date BC_DATE, String BC_ADDRESS, String FK_BC_CURRENCY, Integer BC_QUOTA, Integer FK_BC_BANK) {

        this.BC_ID = BC_ID;
        this.FK_ACCOUNT_ID = FK_ACCOUNT_ID;
        this.BC_NUMBER = BC_NUMBER;
        this.BC_MONEY = BC_MONEY;
        this.BC_STATES = BC_STATES;
        this.BC_PWD = BC_PWD;
        this.BC_DATE = BC_DATE;
        this.BC_ADDRESS = BC_ADDRESS;
        this.FK_BC_CURRENCY = FK_BC_CURRENCY;
        this.BC_QUOTA = BC_QUOTA;
        this.FK_BC_BANK = FK_BC_BANK;
    }

    public Bankcard() {

    }
}
