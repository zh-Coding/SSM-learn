package com.czh.ui;

import com.czh.factory.BeanFactory;
import com.czh.service.AccountService;

/**
 * @author zhCoding
 * @Description:
 * @create 21:00
 */
public class Client {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            AccountService accountService = BeanFactory.getBean("accountService",AccountService.class);
            accountService.saveAccount();
        }
    }

}
