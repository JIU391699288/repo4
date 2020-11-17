package com.zl.controller;

import com.zl.bean.Person;
import com.zl.bean.Personalaccount;
import com.zl.service.UserService;
import com.zl.utils.ExceptionUtils.vo.R;
import com.zl.utils.component.Smscomponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    Smscomponent smscomponent;
    @Autowired
    private RedisTemplate redisTemplate;


//发送验证码
@RequestMapping("/sendCode")
    public  void sendCode(String phone) {

    smscomponent.sendMsg(phone);

    }

    //用户注册
    @RequestMapping("/register")
    public  R register (Person person,String code) {
        String phone = person.getUSER_TEL();
        R result = null;
        String Keycode = (String) redisTemplate.boundValueOps("" + phone).get();
        if (code.equals(Keycode)){
            //删除redis里的键和值
            redisTemplate.delete("" + phone);
            userService.register(person);
            result = R.ok();
            result.setMessage("注册成功");
        }else {
            result = R.error();
            result.setMessage("验证码有误");
        }
        return result;
    }

        //注册用户名比对
        @RequestMapping("/selectName")
        public  R selectName(String selectName) {
                R result = null;
            Person person = userService.selectName(selectName);
            if (person!=null){
                result = R.error();
                result.setMessage("用户名已经存在");
                return result;
            }
            else {
                result = R.ok();
                result.setMessage("用户名通过");
                return result;
            }
        }

    //登录传过来用户对象
    @RequestMapping("/login")
    public String login(Person person, Model model) {

        Person person1 = userService.login(person);

        if (person1!=null){
            System.out.println("登录成功");
            model.addAttribute("person", person);
            return "main";
        }
        else {
            System.out.println("登录失败");
            return "login";

        }
    }

    //账户申请 先调用发短信 在 确认申请

    @RequestMapping("/accountApplication")
    public R accountApplication(Personalaccount personalaccount,String code) {

        String phone = personalaccount.getPhone();
        R result = null;
        String Keycode = (String) redisTemplate.boundValueOps("" + phone).get();
        if (code.equals(Keycode)){
            //删除redis里的键和值
            redisTemplate.delete("" + phone);
            userService.accountApplication(personalaccount);
            result = R.ok();
            result.setMessage("等待管理员审核");

        }else {
            result = R.error();
            result.setMessage("验证码有误");
        }
        return result;



    }
}
