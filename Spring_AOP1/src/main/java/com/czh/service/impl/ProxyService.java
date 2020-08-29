package com.czh.service.impl;

import com.czh.dao.AccountDao;
import com.czh.dao.impl.AccountDaoImpl;
import com.czh.service.AccountService;
import com.czh.utils.TransactionManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhCoding
 * @Description:
 * @create 16:16
 */
public class ProxyService {

//    @Autowired
//    private AccountServiceImpl accountServiceImpl;
//    @Autowired
//    private TransactionManager transactionManager;


    @Bean(name = "asProxy")
    public AccountService getProxyServiceImpl(AccountServiceImpl accountServiceImpl,TransactionManager transactionManager){
        Object o = Proxy.newProxyInstance(accountServiceImpl.getClass().getClassLoader(), accountServiceImpl.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnVal = null;
                try {
                    transactionManager.beginTransaction();
                    returnVal = method.invoke(accountServiceImpl, args);
                    transactionManager.commit();
                    return returnVal;
                }catch (Exception e) {
                    transactionManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    transactionManager.release();
                }
            }
        });
        return (AccountService) o;
    }
//    @Test
//    public void test(){
//        AccountService proxyServiceImpl = getProxyServiceImpl();
//        System.out.println(proxyServiceImpl);
//    }

}
