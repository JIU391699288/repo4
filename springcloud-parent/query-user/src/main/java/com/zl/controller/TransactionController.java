package com.zl.controller;

import com.zl.bean.Transaction;
import com.zl.bean.Transactions;
import com.zl.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    //查询汇款银行卡的汇款明细
    //http://localhost:8083/transaction/findCardTransaction
    @RequestMapping("/findCardTransaction")
    public List<Transactions> findCardTransaction(String bc_number) {

       List<Transactions> transactions = transactionService.findCardTransaction(bc_number);

       return transactions;
    }

    //根据传过来的时间查询对应的汇款明细记录
    //http://localhost:8083/transaction/findCardTransactionByTime
    @RequestMapping("/findCardTransactionByTime")
    public List<Transactions> findCardTransactionByTime(String number,String bc_number) {
        List<Transactions> cardTransactionByTime = transactionService.findCardTransactionByTime(number,bc_number);
        return cardTransactionByTime;


    }
}
