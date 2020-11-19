package com.zl.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.utils.ExceptionUtils.vo.R;
import com.zl.utils.bean.Bankcard;
import com.zl.utils.bean.Personalaccount;
import com.zl.utils.feign.QurryUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class QurryUserController {

    @Autowired
    private QurryUserFeign qurryUserFeign;

    //分页查询所有个人账户
    //http://localhost:18082/feign/finduserpage
//    @RequestMapping("/finduser")
//    public PageInfo<Personalaccount> finduserpage() {
//        PageHelper.startPage(1, 3);
//        List<Personalaccount> personalaccounts = qurryUserFeign.findAll();
//        PageInfo<Personalaccount> pageInfo = new PageInfo<>(personalaccounts);
//        return pageInfo;
//    }

    @RequestMapping("/finduser")
    public R findAll() {
        R result = null;
        List<Personalaccount> personalaccounts = qurryUserFeign.findAll();
        Object json = JSON.toJSON(personalaccounts);
        result = R.ok();
        result.setCode(0);
        result.data("Personalaccountlist", json);
        System.out.println(json);
        return result;
    }

    //根据个人账户id查询所有银行卡
    //测试http://localhost:18082/feign/findcard?accountid=21
    @RequestMapping("/findcard")
    public R findCard(Integer accountid){
        R result = null;
        List<Bankcard> bankcards = qurryUserFeign.findCard(accountid);
        result = R.ok();
        result.setCode(0);
        result.data("bankcards", bankcards);
        System.out.println(bankcards);
        return result;
    }

    //冻结个人账户
    //http://localhost:18082/feign/frozenuser?id=21
    @RequestMapping("/frozenuser")
    public Integer frozenUser(Integer id) {
        Integer count = qurryUserFeign.frozenUser(id);
        return count;
    }

    //解冻个人账户
    //http://localhost:18082/feign/thawuser?id=21
    @RequestMapping("/thawuser")
    public Integer thawUser(Integer id) {
        Integer count = qurryUserFeign.thawUser(id);
        return count;
    }

    //冻结个人账户的某个银行卡( 传入银行卡id)
    //测试http://localhost:18082/feign/frozencard?id=23
    @RequestMapping("/frozencard")
    public Integer frozenCard(Integer id) {
        Integer count = qurryUserFeign.frozenCard(id);
        return count;
    }

    //解冻个人账户的某个银行卡
    //测试http://localhost:18082/feign/thawcard?id=23
    @RequestMapping("/thawcard")
    public Integer thawCard(Integer id) {
        Integer count = qurryUserFeign.thawCard(id);
        return count;
    }

    //查询待审核个人用户
    //http://localhost:18082/feign/selectCheckUser
    @RequestMapping("/selectCheckUser")
    public R selectCheckUser(){
        R result = null;
        List<Personalaccount> personalaccounts =  qurryUserFeign.selectCheckUser();
        Object json = JSON.toJSON(personalaccounts);
        result =R.ok();
        result.setCode(0);
        result.data("items", json);
//        System.out.println(personalaccounts);
        return result;
    }
}
