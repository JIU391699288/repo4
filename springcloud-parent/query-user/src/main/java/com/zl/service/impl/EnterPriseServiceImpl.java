package com.zl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.bean.Bankcard;
import com.zl.bean.Enterprise;
import com.zl.dao.EnterPriseDao;
import com.zl.service.EnterPriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterPriseServiceImpl implements EnterPriseService {

    @Autowired
    private EnterPriseDao enterPriseDao;

    @Override
    public List<Enterprise> findAllEnter() {

        return enterPriseDao.findAllEnter();
    }
    //实现类：
    @Override
    public PageInfo<Enterprise> pageHelperList(Integer page, Integer size) {
        //1）静态分页
        PageHelper.startPage(page, size);
        //2）集合查询
        List<Enterprise> enterpriseList = enterPriseDao.findAllEnter();
        //3）返回PageInfo:包含数据结果集+分页信息
        return new PageInfo<Enterprise>(enterpriseList);
    }

    @Override
    public List<Bankcard> findCard(Integer accountid) {
        List<Bankcard>  bankcards = enterPriseDao.findCard(accountid);
        return bankcards;
    }

    //实现类：
    @Override
    public PageInfo<Bankcard> pageHelperLists(Integer page, Integer size,Integer accountid) {
        //1）静态分页
        PageHelper.startPage(page, size);
        //2）集合查询
        List<Bankcard> bankcards = enterPriseDao.findCard(accountid);
        //3）返回PageInfo:包含数据结果集+分页信息
        return new PageInfo<Bankcard>(bankcards);
    }

    @Override
    public Integer frozenCardEnter(Integer accountid) {
       int count = enterPriseDao.frozenCardEnter(accountid);
        return count;
    }

    @Override
    public Integer thawCardEnter(Integer accountid) {
        int count = enterPriseDao.thawCardEnter(accountid);
        return count;
    }

    @Override
    public Integer frozenCard(Integer id) {
        int count = enterPriseDao.frozenCard(id);
        return count;
    }

    @Override
    public Integer thawCard(Integer id) {
        int count = enterPriseDao.thawCard(id);
        return count;
    }
}
