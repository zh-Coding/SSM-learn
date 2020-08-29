package com.czh.test;

import com.czh.dao.AccountDao;
import com.czh.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 13:32
 */
public class AccountDaoTest {

    SqlSession sqlSession;
    AccountDao accountDao;
    InputStream is;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll(){
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.print(account);
            System.out.println(account.getUser1());
        }
    }

    @Test
    public  void testFindAccountByUid(){
        Account accountByUid = accountDao.findAccountByUid(41);
        System.out.println(accountByUid);
    }

}
