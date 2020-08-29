package com.czh.test;

import com.czh.dao.RoleDao;
import com.czh.domain.Role;
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
 * @create 14:55
 */
public class RoleTest {
    InputStream is;
    SqlSession sqlSession;
    RoleDao roleDao;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
    }
    @After
    public void close() throws IOException {
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll(){
        List<Role> all = roleDao.findAll();
        for (Role role : all) {
            System.out.print(role);
            System.out.println(role.getUser1s());
        }
    }

}
