package com.zl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.bean.Bankcard;
import com.zl.bean.Personalaccount;
import com.zl.dao.QurryUserDao;
import com.zl.service.QurryUserService;
import com.zl.utils.component.IdCardVerComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QurryUserServiceImpl implements QurryUserService {
    @Autowired
    private QurryUserDao qurryUserDao;

    public List<Personalaccount> findAll() {
        return qurryUserDao.findAll();
    }

    //实现类：
    @Override
    public PageInfo<Personalaccount> pageHelperList(Integer page, Integer size) {
        //1）静态分页
        PageHelper.startPage(page, size);
        //2）集合查询
        List<Personalaccount> personalaccounts = qurryUserDao.findAll();
        //3）返回PageInfo:包含数据结果集+分页信息
        return new PageInfo<Personalaccount>(personalaccounts);
    }

    @Override
    public List<Bankcard> findCard(Integer accountid) {
        return qurryUserDao.findCard(accountid);
    }

    //实现类：
    @Override
    public PageInfo<Bankcard> pageHelperLists(Integer page, Integer size,Integer accountid) {
        //1）静态分页
        PageHelper.startPage(page, size);
        //2）集合查询
        List<Bankcard> products = qurryUserDao.findCard(accountid);
        //3）返回PageInfo:包含数据结果集+分页信息
        return new PageInfo<Bankcard>(products);
    }
    @Override
    public Integer frozenUser(Integer id) {
        return qurryUserDao.frozenUser(id);
    }

    @Override
    public Integer thawUser(Integer id) {
        return qurryUserDao.thawUser(id);
    }

    @Override
    public Integer frozenCard(Integer id) {
        return qurryUserDao.frozenCard(id);
    }

    @Override
    public Integer thawCard(Integer id) {
        return qurryUserDao.thawCard(id);
    }

    @Override
    public int updateUser(String idCard) {
        return qurryUserDao.updateUser(idCard);
    }

    @Override
    public int deleteUser(String idCard) {
        return qurryUserDao.deleteUser(idCard);
    }

}
