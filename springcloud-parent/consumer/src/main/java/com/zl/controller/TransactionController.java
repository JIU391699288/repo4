package com.zl.controller;

import com.zl.utils.bean.Transactions;
import com.zl.utils.feign.QurryUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/feign")
public class TransactionController {

    @Autowired
    private QurryUserFeign qurryUserFeign;

    //查询汇款银行卡的汇款明细
    //http://localhost:18082/feign/findCardTransaction?bc_number=1111111111111111
    @RequestMapping("/findCardTransaction")
    public List<Transactions> findCardTransaction(String bc_number) {

       List<Transactions> transactions = qurryUserFeign.findCardTransaction(bc_number);

       return transactions;
    }


    //根据传过来的时间查询对应的汇款明细记录
    //http://localhost:18082/feign/findCardTransactionByTime?number=31
    @RequestMapping("/findCardTransactionByTime")
    public List<Transactions> findCardTransactionByTime(Integer number) {
        List<Transactions> cardTransactionByTime = qurryUserFeign.findCardTransactionByTime(number);
        return cardTransactionByTime;


    }
}
