package com.czh.test;

import com.czh.dao.User2Dao;
import com.czh.domain.User2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 18:05
 */
public class AnnotationTest {
    InputStream is;
    SqlSession sqlSession;
    User2Dao user2Dao;


    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        user2Dao = sqlSession.getMapper(User2Dao.class);

    }
    @After
    public void close() throws IOException {
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll(){
        List<User2> all = user2Dao.findAll();
        for (User2 user2 : all) {
            System.out.print(user2);
            System.out.println(user2.getAccount2s());
        }
    }

    @Test
    public void testSave() throws ParseException {

        user2Dao.saveUser2(new User2(null,"淦哦",
                new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"),"男","九龙"));
        sqlSession.commit();
    }
    @Test
    public void testUpdate() throws ParseException {

        user2Dao.updateUser2(new User2(57,"小黄",
                new SimpleDateFormat("yyyy-MM-dd").parse("200-01-01"),"男","小九龙"));
        sqlSession.commit();
    }
    @Test
    public void testDelete() throws ParseException {

        user2Dao.deleteUser2ById(54);
        sqlSession.commit();
    }
    @Test
    public void testFindById(){

        User2 user2ById = user2Dao.findUser2ById(56);
        System.out.println(user2ById);
    }

}
