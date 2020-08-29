package com.czh.service.impl;

import com.czh.dao.AccountDao;
import com.czh.domain.Account3;
import com.czh.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 16:30
 */
@Service
public class AccountServiceImpl implements AccountService {
    private static AccountDao accountDao;
    static {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = factory.openSession();
            accountDao = sqlSession.getMapper(AccountDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
