package com.zl.dao;

import com.zl.bean.Bankcard;
import com.zl.bean.Enterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EnterPriseDao{

    @Select("select * from enterprise")
    List<Enterprise> findAllEnter();

    @Select("select * from bankcard where FK_ACCOUNT_ID=#{accountid} and FK_AT_AID=1")
    List<Bankcard> findCard(Integer accountid);
    @Update("update enterprise set state=0 where accountid=#{accountid}")
    int frozenCardEnter(Integer accountid);
    @Update("update enterprise set state=1 where accountid=#{accountid}")
    int thawCardEnter(Integer accountid);
    @Update("update bankcard set BC_STATES=0 where BC_ID=#{id} and FK_AT_AID=1")
    int frozenCard(Integer id);
    @Update("update bankcard set BC_STATES=1 where BC_ID=#{id} and FK_AT_AID=1")
    int thawCard(Integer id);
}
