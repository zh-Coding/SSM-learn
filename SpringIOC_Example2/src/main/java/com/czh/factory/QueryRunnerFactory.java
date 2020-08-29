package com.czh.factory;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhCoding
 * @Description:
 * @create 17:53
 */
public class QueryRunnerFactory {
    private static DataSource source;
    static {
        try {
            Properties pros = new Properties();
            InputStream is = QueryRunnerFactory.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pros.load(is);

            source= DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Bean
    public static QueryRunner getQueryRunner(){
        QueryRunner queryRunner = new QueryRunner(source);
        System.out.println(queryRunner);
        return queryRunner;
    }

}
