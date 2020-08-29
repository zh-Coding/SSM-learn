package com.czh.service.impl;

import com.czh.dao.AccountDao;
import com.czh.factory.BeanFactory;
import com.czh.service.AccountService;

/**
 * @author zhCoding
 * @Description:
 * @create 20:57
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = BeanFactory.getBean("accountDao",AccountDao.class);

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
