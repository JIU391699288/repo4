package com.zl.controller;

import com.alibaba.fastjson.JSON;
import com.zl.utils.ExceptionUtils.vo.R;
import com.zl.utils.bean.Bankcard;
import com.zl.utils.bean.Personalaccount;
import com.zl.utils.component.IdCardVerComponent;
import com.zl.utils.feign.QurryUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/feign")
public class QurryUserController {

    @Autowired
    private QurryUserFeign qurryUserFeign;
    @Autowired
    IdCardVerComponent idCardVerComponent;

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
    @ResponseBody
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
    @ResponseBody
    @RequestMapping("/findcard")
    public R findCard(Integer accountid) {
        R result = null;
        List<Bankcard> bankcards = qurryUserFeign.findCard(accountid);
        result = R.ok();
        result.setCode(0);
        result.data("bankcards", bankcards);
        System.out.println(bankcards);
        return result;
    }

    @RequestMapping("/tool")
    public String tools(Integer accountid, Model model) {
        model.addAttribute("accountid", accountid);
        return "backcard-list";
    }

    //冻结个人账户
    //http://localhost:18082/feign/frozenuser?id=21
    @RequestMapping("/frozenuser")
    public String frozenUser(Integer pid) {
        System.out.println(pid);
        Integer count = qurryUserFeign.frozenUser(pid);
        System.out.println(count);
        return "account-list";
    }

    //解冻个人账户
    //http://localhost:18082/feign/thawuser?id=21
    @RequestMapping("/thawuser")
    public String thawUser(Integer pid) {
        Integer count = qurryUserFeign.thawUser(pid);
        return "account-list";
    }

    //冻结个人账户的某个银行卡( 传入银行卡id)
    //测试http://localhost:18082/feign/frozencard?id=23
    @RequestMapping("/frozencard")
    public String frozenCard(Integer bc_id,Integer fk_account_id) {
        Integer count = qurryUserFeign.frozenCard(bc_id);
        return "redirect/feign/tool?accountid"+fk_account_id;
    }

    //解冻个人账户的某个银行卡
    //测试http://localhost:18082/feign/thawcard?id=23
    @RequestMapping("/thawcard")
    public String thawCard(Integer bc_id ,Integer fk_account_id) {
        Integer count = qurryUserFeign.thawCard(bc_id);
        return "redirect/feign/tool?accountid"+fk_account_id;
    }

    //查询待审核个人用户
    //http://localhost:18082/feign/selectCheckUser
    @RequestMapping("/selectCheckUser")
    @ResponseBody
    public R selectCheckUser() {
        R result = null;
        List<Personalaccount> personalaccounts = qurryUserFeign.selectCheckUser();
        Object json = JSON.toJSON(personalaccounts);
        result = R.ok();
        result.setCode(0);
        result.data("items", json);
//        System.out.println(personalaccounts);
        return result;
    }


    //个人开户审核
    @RequestMapping("/checkUser")
    public String checkUser(String idCard, String name ) {
        String massage = qurryUserFeign.checkUser(idCard, name);

        if (massage.equals("通过")){

            return "Individual-review-list";
        }
        else{

            return "Individual-review-list";
        }
//        return "redirect/feign/selectCheckUser";
    }
}
