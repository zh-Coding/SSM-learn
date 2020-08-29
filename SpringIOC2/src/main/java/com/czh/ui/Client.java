package com.czh.ui;

import com.czh.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhCoding
 * @Description:
 * @create 21:00
 */
public class Client {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext();
        AccountService accountService3 = context.getBean("accountService3", AccountService.class);
        AccountService as = context.getBean("accountService", AccountService.class);
        System.out.println(accountService3);
        as.saveAccount();
    }

}
