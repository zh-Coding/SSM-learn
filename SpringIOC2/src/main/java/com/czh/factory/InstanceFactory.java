package com.czh.factory;

import com.czh.service.AccountService;
import com.czh.service.impl.AccountServiceImpl;

/**
 * @author zhCoding
 * @Description:
 * @create 23:18
 */
public class InstanceFactory {

    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }

}
