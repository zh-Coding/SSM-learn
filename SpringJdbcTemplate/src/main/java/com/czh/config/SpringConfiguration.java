package com.czh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhCoding
 * @Description:
 * @create 22:24
 */
@Configuration
@ComponentScan(basePackages = "com.czh")
@Import(value = {JDBCTemplateConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {
}
