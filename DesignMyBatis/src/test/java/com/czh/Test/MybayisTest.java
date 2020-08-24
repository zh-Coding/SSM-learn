package com.czh.Test;


import com.czh.DIYMyBatis.SqlSenssion.SqlSession;
import com.czh.DIYMyBatis.SqlSenssion.SqlSessionFactory;
import com.czh.DIYMyBatis.SqlSenssion.SqlSessionFactoryBuilder;
import com.czh.DIYMyBatis.resource.Resources;
import com.czh.dao.UserDao;
import com.czh.domian.User;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mabatis入门
 *
 * @author zhCoding
 * @Description:
 * @create 21:19
 */
public class MybayisTest {

    public static void main(String[] args) throws Exception {

        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用Sqlsession创建Dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
        //6.释放资源
        sqlSession.closer();
        is.close();

    }

}
