package com.zl.dao;

import com.zl.bean.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionDao {

    @Select("select answer from question where question like '%${question}%'")
    String selectQuestion(String question);
}
