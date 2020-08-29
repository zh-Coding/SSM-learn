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
        List<Account3> all = asi.findAll();
        for (Account3 account3 : all) {
            System.out.println(account3);
        }
    }

}
