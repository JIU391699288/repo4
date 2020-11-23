package com.zl.service.impl;

import com.zl.bean.Transaction;
import com.zl.bean.Transactions;
import com.zl.dao.TransactionDao;
import com.zl.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.internal.util.LinkedArrayList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDao transactionDao;

    @Override
    public List<Transactions> findCardTransaction(String bc_number) {
        List<Transaction> transactions = transactionDao.findCardTransaction(bc_number);
        ArrayList<Transactions> al = new ArrayList();

        for (int i = 0; i <transactions.size() ; i++) {
//            System.out.println(transactions.get(i));
            //收款方卡号和传入过来的卡号相等 代表是转入
            if (transactions.get(i).getTra_receivenum().equals(bc_number)){
                Transactions trabs = new Transactions();
                Integer tra_id = transactions.get(i).getTra_id();
                Date tra_time = transactions.get(i).getTra_time();
                String tra_money = String.valueOf(transactions.get(i).getTra_money());
                trabs.setTra_id(tra_id);
                trabs.setTra_time(tra_time);
                trabs.setMoney(tra_money);
                al.add(trabs);

            }
            //付款方卡号和传入过来的卡号相等 代表是转出
            else {
                Transactions trabs = new Transactions();
                Integer tra_id = transactions.get(i).getTra_id();
                Date tra_time = transactions.get(i).getTra_time();
                String tra_money = "-"+String.valueOf(transactions.get(i).getTra_money());
                trabs.setTra_id(tra_id);
                trabs.setTra_time(tra_time);
                trabs.setMoney(tra_money);
                al.add(trabs);
            }
            }


        return al;
    }

    @Override
    public List<Transactions> findCardTransactionByTime(String number,String bc_number) {
        List<Transaction> transactions = transactionDao.findCardTransactionByTime(number,bc_number);
        System.out.println(transactions);
        ArrayList<Transactions> al = new ArrayList();
        for (int i = 0; i <transactions.size() ; i++) {
//            System.out.println(transactions.get(i));
            //收款方卡号和传入过来的卡号相等 代表是转入
            if (transactions.get(i).getTra_receivenum().equals(bc_number)){
                Transactions trabs = new Transactions();
                Integer tra_id = transactions.get(i).getTra_id();
                Date tra_time = transactions.get(i).getTra_time();
                String tra_money = String.valueOf(transactions.get(i).getTra_money());
                trabs.setTra_id(tra_id);
                trabs.setTra_time(tra_time);
                trabs.setMoney(tra_money);
                al.add(trabs);

            }
            //付款方卡号和传入过来的卡号相等 代表是转出
            else {
                Transactions trabs = new Transactions();
                Integer tra_id = transactions.get(i).getTra_id();
                Date tra_time = transactions.get(i).getTra_time();
                String tra_money = "-"+String.valueOf(transactions.get(i).getTra_money());
                trabs.setTra_id(tra_id);
                trabs.setTra_time(tra_time);
                trabs.setMoney(tra_money);
                al.add(trabs);
            }
        }


        return al;

    }
}
