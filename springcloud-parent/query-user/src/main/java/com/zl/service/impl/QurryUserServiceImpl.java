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

    @Override
    public List<Bankcard> findCard(Integer accountid) {
        return qurryUserDao.findCard(accountid);
    }

    @Override
    public Integer frozenUser(Integer id) {
        System.out.println(id);

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

    @Override
    public List<Personalaccount> selectCheckUser() {
        List<Personalaccount> personalaccounts = qurryUserDao.selectCheckUser();
        return personalaccounts;
    }

}
