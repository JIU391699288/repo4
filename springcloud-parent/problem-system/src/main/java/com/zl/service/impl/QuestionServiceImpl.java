package com.zl.service.impl;

import com.zl.bean.Question;
import com.zl.dao.QuestionDao;
import com.zl.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public String selectQuestion(String question) {

        String s = questionDao.selectQuestion(question);
        return s;
    }
}
