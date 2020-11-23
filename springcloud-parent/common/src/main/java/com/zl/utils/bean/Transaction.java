package com.zl.utils.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易明细
 */
@Data
public class Transaction implements Serializable {
    //交易id
    Integer tra_id;
    //收款方姓名
    String tra_receivename;
    //收款方卡号
    String tra_receivenum;
    //收款方银行
    String tra_bank;
    //汇款方姓名
    String tra_remittancename;
    //汇款方卡号
    String tra_remitttancenum;
    //汇款方银行
    String tra_remittancebank;
    //交易时间（汇款时间）
    Date tra_time;
    //汇款币种
    String tra_currency;
    //汇款金额
    Double tra_money;
    //汇款类型(单笔 批量....)
    String tra_usertrance;
    //汇款到账类型
    String tra_accountingtype;
    //汇款类型详情（公对公公对私）
    String tra_remtypedetail;
    //汇款利率或者手续费
    Double tra_chargesfee;
    //汇款方手机号
    String tra_phone;
    //交易编号
    Long tra_number;
}
