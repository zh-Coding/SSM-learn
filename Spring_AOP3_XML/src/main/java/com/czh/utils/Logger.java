package com.czh.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author zhCoding
 * @Description: 记录日志的工具类
 * @create 18:45
 */
@Component
@Aspect
public class Logger {
    @Pointcut("execution(* com.czh.service.impl.AccountServiceImpl.*(..))")
    private void pc1(){}

    /**
     *
     */
    @Before("pc1()")
    public void beforePrintLog(){
        System.out.println("前置通知");
    }

    @AfterReturning("pc1()")
    public void afterReturnPrintLog(){
        System.out.println("后置通知");
    }
    @After("pc1()")
    public void afterPrintLog(){
        System.out.println("最终通知");
    }
    @Around("pc1()")
    public void aroundPrintLog(ProceedingJoinPoint pjp){
        System.out.println("环绕前置");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后置");
    }
    @AfterThrowing("pc1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知");
    }



}
