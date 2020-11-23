package com.zl.utils.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易明细
 */
@Data
public class Transactions implements Serializable {
    //交易id
    Integer tra_id;
    //交易时间（汇款时间）
    Date tra_time;
    //金额(有可能为正或者为负)
    String money;
}
