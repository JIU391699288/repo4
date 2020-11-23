package com.zl.dao;

import com.zl.bean.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TransactionDao {

    @Select("select * from transactiontable where TRA_REMITTTANCENUM = #{bc_number} or TRA_RECEIVENUM = #{bc_number}")
    List<Transaction> findCardTransaction(String bc_number);

   @Select("select * from transactiontable where (TRA_TIME " +
           "between to_date(to_char(sysdate- #{number,jdbcType=VARCHAR},'yyyy/mm/dd'),'yyyy/mm/dd')\n" +
           "and to_date(to_char(sysdate,'yyyy/mm/dd'),'yyyy/mm/dd') ) and TRA_REMITTTANCENUM = #{bc_number,jdbcType=VARCHAR} or TRA_RECEIVENUM = #{bc_number,jdbcType=VARCHAR}")
   List<Transaction> findCardTransactionByTime(@Param(value ="number" ) String number, @Param(value ="bc_number" )String bc_number);
}
