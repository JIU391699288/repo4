package com.zl.service;


import com.github.pagehelper.PageInfo;
import com.zl.bean.Bankcard;
import com.zl.bean.Enterprise;

import java.util.List;

public interface EnterPriseService {

    List<Enterprise> findAllEnter();

    PageInfo<Enterprise> pageHelperList(Integer page, Integer size);

    List<Bankcard> findCard(Integer accountid);

    PageInfo<Bankcard> pageHelperLists(Integer page, Integer size,Integer accountid);

    Integer frozenCardEnter(Integer accountid);

    Integer thawCardEnter(Integer accountid);

    Integer frozenCard(Integer id);

    Integer thawCard(Integer id);

    List<Enterprise> selectCheckEnter();
}
