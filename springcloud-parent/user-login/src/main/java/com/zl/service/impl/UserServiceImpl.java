package com.zl.service.impl;

import com.zl.bean.Person;
import com.zl.bean.Personalaccount;
import com.zl.dao.UserDao;
import com.zl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void register(Person person) {

        userDao.register(person);
    }

    @Override
    public Person login(Person person) {

        Person persons = userDao.login(person);
        return  person;
    }

    @Override
    public Person selectName(String selectName) {
        Person person = userDao.selectName(selectName);
        return person;
    }

    @Override
    public void accountApplication(Personalaccount personalaccount) {
        personalaccount.setState(0);
        userDao.accountApplication(personalaccount);

    }
}
