package com.zl.service;

import com.zl.bean.Transaction;
import com.zl.bean.Transactions;

import java.util.List;

public interface TransactionService {
    List<Transactions> findCardTransaction(String bc_number);

    List<Transactions> findCardTransactionByTime(String number,String bc_number);
}
