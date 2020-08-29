package com.czh;

import com.czh.dao.AccountDao;
import com.czh.domain.Account3;
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
 * @create 16:43
 */
public class AccoutDaoTest {

    InputStream is;
    SqlSession sqlSession;
    AccountDao accountDao;
    @Before
    public void init() throws Exception {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }
    @After
    public void close () throws IOException {
        sqlSession.close();
        is.close();
    }
    @Test
    public void test1(){
        List<Account3> all = accountDao.findAll();
        all.forEach(System.out::println);
    }
    @Test
    public void test2(){
        Account3 byId = accountDao.findById(2);
        System.out.println(byId);
    }
    @Test
    public void test3(){
        accountDao.saveAccount(new Account3(null,"dddd",1500.0f));
        sqlSession.commit();
    }
}
