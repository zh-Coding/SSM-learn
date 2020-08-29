package com.czh.cglib;

/**
 * @author zhCoding
 * @Description:
 * @create 17:22
 */
public class Producer {

    public void saleProduct(float money){
        System.out.println("销售获得 "+money);
    }

    public void afterService(float money){
        System.out.println("提供售后，获得"+money);
    }

}
