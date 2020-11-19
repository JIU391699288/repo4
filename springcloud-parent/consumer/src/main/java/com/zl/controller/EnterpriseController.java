package com.zl.controller;

import com.alibaba.fastjson.JSON;
import com.zl.utils.ExceptionUtils.vo.R;
import com.zl.utils.bean.Bankcard;
import com.zl.utils.bean.Enterprise;
import com.zl.utils.feign.QurryUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class EnterpriseController {
    @Autowired
    private QurryUserFeign qurryUserFeign;

    //查询所有企业账户
    //http://localhost:18082/feign/findAllEnter
    @RequestMapping("/findAllEnter")
    public R findAllEnter() {
        R result = null;
        List<Enterprise> enterpriseList = qurryUserFeign.findAllEnter();
        Object json = JSON.toJSON(enterpriseList);
        result = R.ok();
        result.setCode(0);
        result.data("item", json);
        System.out.println(enterpriseList);
        return result;
    }

    //根据企业账户id查询所有银行卡
    //http://localhost:18082/feign/findEntercard?accountid=3
    @RequestMapping("/findEntercard")
    public List<Bankcard> findEnterCard(Integer accountid) {
        List<Bankcard> bankcards = qurryUserFeign.findCard(accountid);
        System.out.println(bankcards);
        return bankcards;
    }
    //冻结企业账户
    //http://localhost:18082/feign/frozenCardEnter?accountid=3
    @RequestMapping("/frozenCardEnter")
    public Integer frozenCardEnter(Integer accountid) {
        Integer count = qurryUserFeign.frozenCardEnter(accountid);
        return count;
    }


    //解冻企业账户
    //http://localhost:18082/feign/thawCardEnter?accountid=3
    @RequestMapping("/thawCardEnter")
    public Integer thawCardEnter(Integer accountid) {
        Integer count = qurryUserFeign.thawCardEnter(accountid);
        return count;
    }


    //冻结企业账户的某个银行卡( 传入银行卡id)
    //测试http://localhost:18082/feign/frozencards?id=22
    @RequestMapping("/frozencards")
    public Integer frozenCards(Integer id) {
        Integer count = qurryUserFeign.frozenCard(id);
        return count;
    }

    //解冻企业账户的某个银行卡( 传入银行卡id)
    //测试http://localhost:18082/feign/thawcards?id=22
    @RequestMapping("/thawcards")
    public Integer thawCards(Integer id) {
        Integer count = qurryUserFeign.thawCard(id);
        return count;
    }


    //查询待审核个人用户
    //http://localhost:18082/feign/selectCheckEnter
    @RequestMapping("/selectCheckEnter")
    public R selectCheckEnter( ){
        R result = null;
        List<Enterprise> enterprises =  qurryUserFeign.selectCheckEnter();
        Object json = JSON.toJSON(enterprises);
        result = R.ok();
        result.setCode(0);
        result.data("item", json);
        return result;
    }
}
