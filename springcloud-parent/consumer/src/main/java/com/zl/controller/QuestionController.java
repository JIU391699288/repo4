package com.zl.controller;


import com.alibaba.fastjson.JSON;

import com.zl.utils.ExceptionUtils.vo.R;
import com.zl.utils.feign.QuestionFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class QuestionController {
    @Autowired
    private QuestionFeign questionFeign;

    @RequestMapping("/select")
    public R selectQuestion(String question) {
        R result =null;
        String anoswer = questionFeign.selectQuestion(question);
        System.out.println(anoswer);
        Object json = JSON.toJSON(anoswer);
        result=R.ok();
        result.setCode(20000);
        result.data("item", json);

        return result;
    }
}
