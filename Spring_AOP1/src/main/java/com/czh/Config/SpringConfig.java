package com.czh.Config;

import com.czh.service.impl.ProxyService;
import org.springframework.context.annotation.*;

/**
 * @author zhCoding
 * @Description:
 * @create 14:23
 */
@Configuration
@ComponentScan(basePackages = {"com.czh"})
@EnableAspectJAutoProxy
@Import(value = {JDBCConfig.class})
@PropertySource(value = "classpath:jdbc.properties")
public class SpringConfig {
}
