package com.zl.controller;

import com.alibaba.fastjson.JSON;
import com.zl.utils.ExceptionUtils.vo.R;
import com.zl.utils.bean.Bankcard;
import com.zl.utils.bean.Enterprise;
import com.zl.utils.feign.QurryUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/feign")
public class EnterpriseController {
    @Autowired
    private QurryUserFeign qurryUserFeign;

    //查询所有企业账户
    //http://localhost:18082/feign/findAllEnter
    @RequestMapping("/findAllEnter")
    @ResponseBody
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


    @RequestMapping("/toolEnterCard")
    public String toolEnterCard(Integer accountid, Model model) {
        System.out.println(accountid);
        model.addAttribute("accountid", accountid);
        return "enter-bankcard-list";
    }

    //根据企业账户id查询所有银行卡
    //http://localhost:18082/feign/findEntercard?accountid=3
    @RequestMapping("/findEntercard")
    @ResponseBody
    public R findEnterCard(Integer accountid) {
        R result = null;
        List<Bankcard> bankcards = qurryUserFeign.findEnterCard(accountid);
        Object json = JSON.toJSON(bankcards);
        result = R.ok();
        result.setCode(0);
        result.data("items", json);
        System.out.println(bankcards);
        return result;
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
    @ResponseBody
    public R selectCheckEnter() {
        R result = null;
        List<Enterprise> enterprises = qurryUserFeign.selectCheckEnter();
        Object json = JSON.toJSON(enterprises);
        result = R.ok();
        result.setCode(0);
        result.data("item", json);
        return result;
    }
    //企业开户审核
    @RequestMapping("/checkEnter")
    public String checkEnter(String idCard, String name ) {
        System.out.println(idCard);
        System.out.println(name);
        String massage = qurryUserFeign.checkEnter(idCard, name);
        System.out.println(massage);
        if(massage.equals("通过")){
            ;
            return "Enterprise-audit-list";
        }
        else{

            return "Enterprise-audit-list";
        }
//        return "redirect/feign/selectCheckUser";
    }
}
