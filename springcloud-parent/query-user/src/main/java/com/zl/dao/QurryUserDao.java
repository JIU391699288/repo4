package com.zl.dao;

import com.zl.bean.Bankcard;
import com.zl.bean.Personalaccount;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface QurryUserDao {
    @Select("select * from personalaccount")
    List<Personalaccount> findAll();


    @Select("select * from bankcard where FK_ACCOUNT_ID=#{accountid} and FK_AT_AID=0")
    List<Bankcard> findCard(Integer accountid);

    @Update("update personalaccount set state=0 where pid=#{id}")
    Integer frozenUser(Integer id);

    @Update("update personalaccount set state=1 where pid=#{id}")
    Integer thawUser(Integer id);

    @Update("update bankcard set BC_STATES=0 where BC_ID=#{id} and FK_AT_AID=0")
    Integer frozenCard(Integer id);

    @Update("update bankcard set BC_STATES=1 where BC_ID=#{id} and FK_AT_AID=0")
    Integer thawCard(Integer id);

    @Update("update personalaccount set state=1 where idcard=#{idCard}")
    int updateUser(String  idCard);

    @Delete("delete from personalaccount where idcard=#{idCard}")
    int deleteUser(String  idCard);

    @Select("select * from personalaccount where trunc(REGISTRATIONTIM) = trunc(Sysdate) and state =0")
    List<Personalaccount> selectCheckUser();
}
