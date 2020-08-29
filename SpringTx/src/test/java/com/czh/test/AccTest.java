package com.czh.test;

import com.czh.config.SpringConfiguration;
import com.czh.domain.Account;
import com.czh.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhCoding
 * @Description:
 * @create 13:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.transfer("eee","yyy",500.0f);
    }

    @Test
    public void test2(){
        Account accById = accountService.findAccById(9);
        System.out.println(accById);
    }
}
