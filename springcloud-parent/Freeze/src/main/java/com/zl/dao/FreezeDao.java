package com.zl.dao;

import com.zl.bean.Bankcard;
import com.zl.bean.PersonAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FreezeDao {

    @Select("select * from personalaccount")
    List<PersonAccount> findAllAccount();

    @Select("select * from bankcard where accountid = #{id}")
    List<Bankcard> findAllBankCard(Integer id);
}
