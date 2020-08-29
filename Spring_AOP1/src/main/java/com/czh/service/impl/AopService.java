package com.czh.service.impl;

import com.czh.utils.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

/**
 * @author zhCoding
 * @Description:
 * @create 21:42
 */
@Component
@Aspect
public class AopService {
    @Autowired
    private TransactionManager transactionManager;

    @Pointcut("execution(* com.czh.service.impl.AccountServiceImpl.*(..))")
    public void pcut(){}

    @Around("pcut()")
    public Object around(ProceedingJoinPoint pjp){
        Object rtVal=null;
        try {
            //1.获取参数
            Object[] args = pjp.getArgs();
            transactionManager.beginTransaction();
            //2.执行方法
            rtVal = pjp.proceed(args);
            transactionManager.commit();
            return rtVal;
        } catch (Throwable throwable) {
            transactionManager.rollback();
            throw new RuntimeException(throwable);
        }finally {
            transactionManager.release();
        }
    }
//    @Before("pcut()")
//    public void before(){
//        transactionManager.beginTransaction();
//    }
//
//    @After("pcut()")
//    public void after(){
//        transactionManager.release();
//    }
//    @AfterReturning("pcut()")
//    public void afterReturn(){
//        transactionManager.commit();
//    }
//    @AfterThrowing("pcut()")
//    public void afterThrowing(){
//        transactionManager.rollback();
//    }
}
