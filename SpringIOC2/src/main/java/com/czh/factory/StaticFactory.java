package com.czh.factory;

import com.czh.service.AccountService;
import com.czh.service.impl.AccountServiceImpl;

/**
 * @author zhCoding
 * @Description:
 * @create 23:25
 */
public class StaticFactory {

    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }

}
