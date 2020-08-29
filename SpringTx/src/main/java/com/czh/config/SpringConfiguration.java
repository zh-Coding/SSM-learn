package com.czh.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhCoding
 * @Description:
 * @create 22:24
 */
@Configuration
@ComponentScan(basePackages = "com.czh")
@Import(value = {JDBCTemplateConfig.class,SpringTransactionManagerConfig.class})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {
}
