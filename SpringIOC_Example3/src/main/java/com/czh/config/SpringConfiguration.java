package com.czh.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhCoding
 * @Description: configuration 表明当前类是配置类
 *               ComponentScan
 * @create 19:18
 */
@Configuration
@ComponentScan(basePackages = {"com.czh"})
@Import(JDBCConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {




}
