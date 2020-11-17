package com.zl.dao;

import com.zl.bean.Person;
import com.zl.bean.Personalaccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Insert("insert into person(USER_NAME,USER_PWD,USER_TEL,USER_TYPE) " +
            "values (#{USER_NAME},#{USER_PWD},#{USER_TEL},#{USER_TYPE})" )
    void register(Person person);

    @Select("select * from person where USER_NAME=#{USER_NAME} and USER_PWD =#{USER_PWD}")
    Person login(Person person);

    @Select("select * from person where USER_NAME=#{USER_NAME}")
    Person selectName(String selectName);


    @Insert("insert into personalaccount(userid, pwd,name,idcard,phone,state," +
            "sex,birthday, registrationtim,address) " +
            "values(#{userid},#{pwd},#{name},#{idcard},#{phone}," +
            "#{state},#{sex},#{birthday},#{registrationtim},#{address})")
    void accountApplication(Personalaccount personalaccount);
}
