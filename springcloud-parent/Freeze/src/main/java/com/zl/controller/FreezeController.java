package com.zl.controller;

import com.zl.bean.Bankcard;
import com.zl.bean.PersonAccount;

import com.zl.service.FreezeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/freeze")
public class FreezeController {
    @Autowired
    private FreezeService freezeService;
    //查询所有账户
    @RequestMapping("/findAllAccount")
    public List<PersonAccount> findAllAccount() {
      List<PersonAccount> accounts = freezeService.findAllAccount();
        System.out.println(accounts);
      return accounts;
    }

    //根据账户查询银行卡
    @RequestMapping("/findAllBankCard")
    public List<Bankcard> findAllBankCard(Integer id) {
        System.out.println(id);
        List<Bankcard> bankcards = freezeService.findAllBankCard(id);
        System.out.println(bankcards);
        return bankcards;
    }

}
