package com.zl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.bean.Bankcard;
import com.zl.bean.Enterprise;
import com.zl.service.EnterPriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterPriseController {

    @Autowired
    private EnterPriseService enterPriseService;

//    //查询所有企业账户
//    //http://localhost:8083/enterprise/findAllEnter
//    @RequestMapping("/findAllEnter")
//    public List<Enterprise> findAllEnter() {
//
//      List<Enterprise> enterpriseList = enterPriseService.findAllEnter();
//
//        System.out.println(enterpriseList);
//      return enterpriseList;
//
//    }
    //分页查询所有企业账户
    //http://localhost:8083/enterprise/findAllEnter
    @RequestMapping("/findAllEnterPage")
    public PageInfo<Enterprise> findAllEnterPage() {
        PageHelper.startPage(1, 3);
        List<Enterprise> enterpriseList = enterPriseService.findAllEnter();
        PageInfo<Enterprise> pageInfo = new PageInfo<>(enterpriseList);
        return pageInfo;
    }

//    //根据企业账户id查询所有银行卡
//    //http://localhost:8083/enterprise/findcard?accountid=3
//    @RequestMapping("/findcard")
//    public List<Bankcard> findCard(Integer accountid) {
//        List<Bankcard> bankcards = enterPriseService.findCard(accountid);
//        System.out.println(bankcards);
//        return bankcards;
//    }
    //根据企业账户id 分页查询所有银行卡
    //http://localhost:8083/enterprise/findCardEnterPage?accountid=3
    @RequestMapping("/findCardEnterPage")
    public PageInfo<Bankcard> findCardEnterPage(Integer accountid) {
        PageHelper.startPage(1, 3);
        List<Bankcard> bankcards = enterPriseService.findCard(accountid);
        PageInfo<Bankcard> pageInfo = new PageInfo<>(bankcards);
        return pageInfo;
    }

    //冻结企业账户
    //http://localhost:8083/enterprise/frozenCardEnter?accountid=3
    @RequestMapping("/frozenCardEnter")
    public Integer frozenCardEnter(Integer accountid) {
        Integer count = enterPriseService.frozenCardEnter(accountid);
        return count;
    }
    //解冻企业账户
    //http://localhost:8083/enterprise/thawCardEnter?accountid=3
    @RequestMapping("/thawCardEnter")
    public Integer thawCardEnter(Integer accountid) {
        Integer count = enterPriseService.thawCardEnter(accountid);
        return count;
    }

    //冻结企业账户的某个银行卡( 传入银行卡id)
    //测试http://localhost:8083/enterprise/frozencard?id=22
    @RequestMapping("/frozencard")
    public Integer frozenCard(Integer id) {
        Integer count = enterPriseService.frozenCard(id);
        return count;
    }
    //解冻企业账户的某个银行卡( 传入银行卡id)
    //测试http://localhost:8083/enterprise/thawcard?id=22
    @RequestMapping("/thawcard")
    public Integer thawCard(Integer id) {
        Integer count = enterPriseService.thawCard(id);
        return count;
    }


}