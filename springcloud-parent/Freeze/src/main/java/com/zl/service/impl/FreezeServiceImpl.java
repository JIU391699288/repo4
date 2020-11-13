package com.zl.service.impl;


import com.zl.bean.Bankcard;
import com.zl.bean.PersonAccount;
import com.zl.dao.FreezeDao;
import com.zl.service.FreezeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreezeServiceImpl implements FreezeService {
    @Autowired
    private FreezeDao freezeDao;
    @Override
    public List<PersonAccount> findAllAccount() {
       List<PersonAccount> accounts = freezeDao.findAllAccount();

        return accounts;
    }

    @Override
    public List<Bankcard> findAllBankCard(Integer id) {
        List<Bankcard> bankcard =  freezeDao.findAllBankCard(id);
        return bankcard;
    }

    @Override
    public int freezeAccount(Integer id) {

      int count =   freezeDao.freezeAccount(id);
        return count;
    }

    @Override
    public int freezeBankCard(Integer id) {
       int count = freezeDao.freezeBankCard(id);
        return count;
    }


}
