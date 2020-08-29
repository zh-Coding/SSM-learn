package com.czh.service.impl;

import com.czh.dao.AccountDao;
import com.czh.domain.Account;
import com.czh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhCoding
 * @Description:
 * @create 13:52
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccById(Integer id) {
        return accountDao.findAccById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccByName(sourceName);
        Account target = accountDao.findAccByName(targetName);
        if (money<=source.getMoney()){
            source.setMoney(source.getMoney()-money);
        }else {
            throw new RuntimeException("转账金额不能大于原账户余额");
        }
        target.setMoney(target.getMoney()+money);
        accountDao.updateAcc(source);

        int i=1/0;

        accountDao.updateAcc(target);
    }
}
