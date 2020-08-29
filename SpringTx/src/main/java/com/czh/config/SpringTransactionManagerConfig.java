package com.czh.config;

import org.aspectj.lang.annotation.AdviceName;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * @author zhCoding
 * @Description:
 * @create 14:01
 */
public class SpringTransactionManagerConfig {

    @Bean("transactionManager")
    public PlatformTransactionManager getDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource){
      return new DataSourceTransactionManager(dataSource);
    }

}
