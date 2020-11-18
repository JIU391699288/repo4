package com.zl.utils.feign;


import com.zl.utils.bean.Bankcard;
import com.zl.utils.bean.Enterprise;
import com.zl.utils.bean.Personalaccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@FeignClient("qurry-user")
public interface QurryUserFeign {

    @RequestMapping("/user/finduser")
   public List<Personalaccount> findAll();

    @RequestMapping("/user/findcard")
    public List<Bankcard> findCard(@RequestParam(value = "accountid")Integer accountid);

    @RequestMapping("/user/frozenuser")
    public Integer frozenUser(@RequestParam(value = "id") Integer id);

    @RequestMapping("/user/thawuser")
    public Integer thawUser(@RequestParam(value = "id")Integer id);

    @RequestMapping("/user/frozencard")
    public Integer frozenCard(@RequestParam(value = "id")Integer id);

    @RequestMapping("/user/thawcard")
    public Integer thawCard(@RequestParam(value = "id")Integer id);

    @RequestMapping("/enterprise/findAllEnter")
    public List<Enterprise> findAllEnter();

    @RequestMapping("/enterprise/findEntercard")
    public List<Bankcard> findEnterCard(@RequestParam(value = "accountid")Integer accountid);

    @RequestMapping("/enterprise/frozenCardEnter")
    public Integer frozenCardEnter(@RequestParam(value = "accountid")Integer accountid);

    @RequestMapping("/enterprise/thawCardEnter")
    public Integer thawCardEnter(@RequestParam(value = "accountid")Integer accountid);

    @RequestMapping("/enterprise/frozencards")
    public Integer frozenCards(@RequestParam(value = "id") Integer id);

    @RequestMapping("/enterprise/thawcards")
    public Integer thawCards(@RequestParam(value = "id")Integer id);

}
