package com.zl.service;

import com.github.pagehelper.PageInfo;
import com.zl.bean.Bankcard;
import com.zl.bean.Personalaccount;

import java.util.List;

public interface QurryUserService {
    List<Personalaccount> findAll();

    List<Bankcard> findCard(Integer accountid);
    Integer frozenUser(Integer id);
    Integer thawUser(Integer id);
    Integer frozenCard(Integer id);
    Integer thawCard(Integer id);

    int updateUser(String idCard);

    int deleteUser(String idCard);

    List<Personalaccount> selectCheckUser();

}
