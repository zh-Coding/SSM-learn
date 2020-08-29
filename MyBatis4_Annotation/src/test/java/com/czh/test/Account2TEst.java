package com.czh.test;

import com.czh.dao.AccountDao2;
import com.czh.dao.User2Dao;
import com.czh.domain.Account2;
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
 * @create 19:13
 */
public class Account2TEst {

    InputStream is;
    SqlSession sqlSession;
    AccountDao2 accountDao2;


    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        accountDao2 = sqlSession.getMapper(AccountDao2.class);

    }
    @After
    public void close() throws IOException {
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll(){
        List<Account2> all = accountDao2.findAll();
        for (Account2 account2 : all) {
            System.out.print(account2);
            System.out.println(account2.getUser2());
        }
    }

    @Test
    public void testFindByUid(){
        List<Account2> account2ByUid = accountDao2.findAccount2ByUid(41);
        for (Account2 account2 : account2ByUid) {
            System.out.println(account2);
        }
    }

}
