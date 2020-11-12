package com.zl.service;


import com.zl.bean.Bankcard;
import com.zl.bean.PersonAccount;

import javax.persistence.Id;
import java.util.List;

public interface FreezeService {

    List<PersonAccount> findAllAccount();

    List<Bankcard> findAllBankCard(Integer id);
}
