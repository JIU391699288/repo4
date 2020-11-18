package com.zl.utils.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Enterprise implements Serializable {

    private  Integer accountid;
    private  Integer userid;
    private  String  pwd;
    private  String  registrant;
    private  String idcard;
    private  String   phome;
    private  Integer  state;
    private  String  address;
    private   Date    rtime;


}
