package com.czh.service.impl;

import com.czh.dao.AccountDao;
import com.czh.domain.Account3;
import com.czh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 16:30
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    public List<Account3> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account3 findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public void saveAccount(Account3 account3) {
        accountDao.saveAccount(account3);
    }

    @Override
    public void updateAccount(Account3 account3) {
        accountDao.updateAccount(account3);
    }

    @Override
    public void deleteAcc(Integer id) {
        accountDao.deleteAcc(id);
    }
}
