package com.czh.test;

import com.czh.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhCoding
 * @Description:
 * @create 18:44
 */
public class AccTEst {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AccountService accountService = context.getBean("accountServiceImpl", AccountService.class);
//        accountService.saveAccount();
//        accountService.deleteAcc(1);
        accountService.updateAcc();
    }
}
