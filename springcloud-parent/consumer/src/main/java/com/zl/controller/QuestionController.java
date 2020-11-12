package com.zl.controller;


import com.zl.feign.QuestionFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class QuestionController {
    @Autowired
    private QuestionFeign QuestionFeign;

    @RequestMapping("/select")
    public String selectQuestion(String question) {

        String anoswer = QuestionFeign.selectQuestion(question);

        System.out.println("111");
        System.out.println(2222);

        System.out.println(anoswer);
        return anoswer;
    }
}
