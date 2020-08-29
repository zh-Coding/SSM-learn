package com.czh.service.impl;

import com.czh.dao.AccountDao;
import com.czh.domain.Account3;
import com.czh.service.AccountService;
import com.czh.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 事务控制应该在业务层
 * @author zhCoding
 * @Description:
 * @create 16:30
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
//    @Autowired
//    private TransactionManager tscManager;

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

    @Override
    public void transfer(String sourceName, String targetName, Float money) {


            //1.
            Account3 s = accountDao.findAccByName(sourceName);
            //2.
            Account3 t = accountDao.findAccByName(targetName);
            //3.
            if (s.getMoney()>=money){
                s.setMoney(s.getMoney()-money);
            }else throw new RuntimeException("转账金额大于原账户余额，无法转账！");
            //4
            t.setMoney(t.getMoney()+money);
            //5.
            accountDao.updateAccount(s);

//            int i=1/0;

            //6.
            accountDao.updateAccount(t);


    }
}
