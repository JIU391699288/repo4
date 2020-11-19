package com.zl.controller;


import com.zl.bean.Bankcard;
import com.zl.bean.Personalaccount;
import com.zl.service.QurryUserService;
import com.zl.utils.ExceptionUtils.vo.R;
import com.zl.utils.component.IdCardVerComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class QurryUserController {

    @Autowired
    private QurryUserService qurryUserService;

    @Autowired
    IdCardVerComponent idCardVerComponent;

    //查询所有个人账户
    //http://localhost:8083/user/finduser
    @RequestMapping("/finduser")
    public List<Personalaccount> findAll() {
        List<Personalaccount> personalaccounts = qurryUserService.findAll();
        System.out.println(personalaccounts);
        return personalaccounts;
}

    //根据个人账户id查询所有银行卡
    //测试http://localhost:8083/user/findcard?accountid=21
    @RequestMapping("/findcard")
    public List<Bankcard> findCard(Integer accountid){
        List<Bankcard> bankcards = qurryUserService.findCard(accountid);
        System.out.println(bankcards);
        return bankcards;
    }
////    //根据个人账户id分页查询所有银行卡
////测试http://localhost:8083/user/findcardpage?accountid=21
//    @RequestMapping("/findcardpage")
//    public PageInfo<Bankcard> findcardpage(Integer accountid) {
//        PageHelper.startPage(1, 3);
//        List<Bankcard> productList = qurryUserService.findCard(accountid);
//        PageInfo<Bankcard> pageInfo = new PageInfo<>(productList);
//        return pageInfo;
//    }
    //冻结个人账户
    //http://localhost:8083/user/frozenuser?id=21
    @RequestMapping("/frozenuser")
    public Integer frozenUser(Integer id) {
        Integer count = qurryUserService.frozenUser(id);
        return count;
    }
    //解冻个人账户
    //http://localhost:8083/user/thawuser?id=21
    @RequestMapping("/thawuser")
    public Integer thawUser(Integer id) {
        Integer count = qurryUserService.thawUser(id);
        return count;
    }
    //冻结个人账户的某个银行卡( 传入银行卡id)
    //测试http://localhost:8083/user/frozencard?id=23
    @RequestMapping("/frozencard")
    public Integer frozenCard(Integer id) {
        Integer count = qurryUserService.frozenCard(id);
        return count;
    }

    //解冻个人账户的某个银行卡
    //测试http://localhost:8083/user/thawcard?id=23
    @RequestMapping("/thawcard")
    public Integer thawCard(Integer id) {
        Integer count = qurryUserService.thawCard(id);
        return count;
    }

    //查询待审核个人用户
    //http://localhost:8083/user/selectCheckUser
    @RequestMapping("/selectCheckUser")
    public List<Personalaccount> selectCheckUser( ){
      List<Personalaccount> personalaccounts =  qurryUserService.selectCheckUser();

        System.out.println(personalaccounts);
      return personalaccounts;
    }


    //开户审核
    @RequestMapping("/checkUser")
    public R checkUser(String idCard,String name ) {
        R result = null;
        String json = idCardVerComponent.idCardVer(idCard,name);
        //String code =
        System.out.println(json);
        if (json.contains("实名认证通过")){
            int count = qurryUserService.updateUser(idCard);
            result =  R.ok();
            result.setMessage("开户成功");
            return result;
        }
        else {
            int count = qurryUserService.deleteUser(idCard);
            System.out.println(count);
            result =  R.error();
            result.setMessage("身份验证出错");
            return result;
        }

    }

}
