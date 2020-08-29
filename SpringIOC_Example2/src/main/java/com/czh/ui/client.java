package com.czh.ui;

import com.czh.domain.Account3;
import com.czh.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 17:09
 */
public class client {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicatonContext.xml");
        AccountService asi = context.getBean("accountServiceImpl", AccountService.class);
        Account3 byId = asi.findById(2);
        System.out.println(byId);
        List<Account3> all = asi.findAll();
        for (Account3 account3 : all) {
            System.out.println(account3);
        }
        ClassPathXmlApplicationContext context1 = (ClassPathXmlApplicationContext) context;
        context1.close();
        System.out.println("*************************");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("ApplicatonContext.xml");
        AccountService asi2 = context2.getBean("accountServiceImpl", AccountService.class);
        System.out.println(asi2.findById(2));
    }

}
