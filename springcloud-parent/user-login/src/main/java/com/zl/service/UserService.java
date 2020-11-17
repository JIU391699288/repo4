package com.zl.service;

import com.zl.bean.Person;
import com.zl.bean.Personalaccount;

public interface UserService {

    void register(Person person);

    Person login(Person person);

    Person selectName(String selectName);

    void accountApplication(Personalaccount personalaccount);
}
