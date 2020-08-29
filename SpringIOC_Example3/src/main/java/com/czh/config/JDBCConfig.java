package com.czh.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhCoding
 * @Description:
 * @create 20:11
 */
public class JDBCConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverClassName}")
    private String driver;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${username}")
    private String user;

    @Bean
    @Scope("prototype")  //设置QueryRunner为多例
    public QueryRunner getQueryRunner(@Qualifier("ds1") DataSource dataSource){
        System.out.println(dataSource.getClass().getName()+"@"+Integer.toHexString(hashCode()));
        return new QueryRunner(dataSource);
    }

    @Bean(name = "ds1")
    public DataSource getDataSource(){
        try {
            System.out.println(user);
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setUrl(url);
            druidDataSource.setDriverClassName(driver);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            return druidDataSource;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "ds2")
    public DataSource getDataSource1(){
        try {
            System.out.println(user);
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
            druidDataSource.setDriverClassName(driver);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            return druidDataSource;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
