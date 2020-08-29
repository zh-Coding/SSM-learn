package com.czh.jdbctemplate;

import com.czh.config.SpringConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 *
 * JdbcTemplate的基本用法
 *
 * @author zhCoding
 * @Description:
 * @create 22:10
 */
@Component
public class JdbcTemplateDemo1 {
    @Autowired
    private JdbcTemplate jt;


    public static void main(String[] args) throws IOException {
//        Properties pros = new Properties();
//        InputStream is = JdbcTemplateDemo1.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        pros.load(is);
//        if (is!=null){
//            is.close();
//        }
//        //spring内置数据源
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName(pros.getProperty("jdbc.driverClassName"));
//        ds.setUrl(pros.getProperty("jdbc.url"));
//        ds.setUsername(pros.getProperty("jdbc.username"));
//        ds.setPassword(pros.getProperty("jdbc.password"));
//
//
//        //1.创建JdbcTemplate对象
//        JdbcTemplate jt = new JdbcTemplate(ds);
        //2.执行操作
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        JdbcTemplateDemo1 jtDemo1 = context.getBean("jdbcTemplateDemo1", JdbcTemplateDemo1.class);
//        jtDemo1.jt.execute("insert into account2(name,money) value('eee',10000)");
        jtDemo1.jt.execute("delete from account2 where id=10");
    }

}
