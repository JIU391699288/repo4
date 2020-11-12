package com.zl.controller;


import com.zl.bean.Question;
import com.zl.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //查询问题
    @RequestMapping("/select")
    public String selectQuestion(String question) {

        String anoswer = questionService.selectQuestion(question);

        System.out.println(anoswer);
       return anoswer;
    }
}
