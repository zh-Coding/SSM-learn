package com.czh.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib中被代理的类不能是最终类也就是final类型
 *
 *
 * @author zhCoding
 * @Description:
 * @create 17:22
 */
public class Client {
    public static void main(String[] args) {

        final Producer producer = new Producer();

        Producer proxyProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnVal = null;

                Float money = (Float) objects[0];

                if ("saleProduct".equals(method.getName())){
                    returnVal = method.invoke(producer,money*0.8f);
                }
                return returnVal;
            }
        });

        proxyProducer.saleProduct(10000);

    }
}
