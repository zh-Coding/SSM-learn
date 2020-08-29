package com.czh.jdbctemplate;

import com.czh.config.SpringConfiguration;
import com.czh.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 22:41
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        JdbcTemplate jt = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jt);
        //3.执行操作
        //增
//        jt.update("insert into account2 values (null,?,?)","xxx","2000");
        //删
//        jt.update("delete from account2 where id = ?",7);
        //改
//        jt.update("update account2 set name=?,money=? where id=?","yyy","2500",8);
        //查
        List<Account> all = jt.query("select * from account2", new ResultSetExtractor<List<Account>>() {
            @Override
            public List<Account> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                List<Account> list = new ArrayList<>();
                while (resultSet.next()) {
                    Account ac = new Account();
                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        try {
                            String columnLabel = rsmd.getColumnLabel(i + 1);
                            Field field = Account.class.getDeclaredField(columnLabel);
                            Class<?> type = field.getType();
                            field.setAccessible(true);
                            field.set(ac, type.cast(resultSet.getObject(i + 1)));
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(ac);
                }
                return list;
            }
        });
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void test1(){

        Field[] fields = Account.class.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getType().getName();
            System.out.println(field.getType());
        }
    }
}
