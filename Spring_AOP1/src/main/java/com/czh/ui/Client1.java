package com.czh.ui;

import com.czh.Config.SpringConfig;
import com.czh.domain.Account3;
import com.czh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 17:09
 */
@Component
public class Client1 {

    @Autowired
    public  AccountService as;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Client1 client1 = context.getBean("client1", Client1.class);

        Account3 byId = client1.as.findById(2);
        System.out.println(byId);
        List<Account3> all = client1.as.findAll();
        for (Account3 account3 : all) {
            System.out.println(account3);
        }
    }



}
