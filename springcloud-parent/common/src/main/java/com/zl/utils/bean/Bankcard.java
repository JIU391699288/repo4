package com.zl.utils.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Bankcard implements Serializable {
   private Integer bc_id;
   private Integer fk_account_id;
   private String bc_number;
   private Integer bc_money;
   private Integer bc_states;
   private String bc_pwd;
   private Date bc_date;
   private String bc_address;
   private String fk_bc_currency;
   private Integer bc_quota;
    private Integer fk_bc_bank;

}
