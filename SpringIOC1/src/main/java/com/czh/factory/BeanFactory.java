package com.czh.factory;

import com.czh.service.AccountService;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author zhCoding
 * @Description:
 * @create 21:10
 */
public class BeanFactory<E> {
    private static Properties pros;

    //定义一个Map，用于存放我们要创建的对象，也就是bean容器
    private static Map<String,Object> beans;

    static {
        try {
            pros = new Properties();
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            pros.load(is);
            Enumeration keys = pros.keys();
            beans = new HashMap<>();
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanClassName = pros.getProperty(key);
                Object o = BeanFactory.class.forName(beanClassName).newInstance();
                beans.put(key,o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static <T> T getBean(String beanName,Class<T> clazz){
        return (T)beans.get(beanName);
    }
//    public static <T> T getBean(String beanName,Class<T> clazz)  {
//
//        try {
//            String beanClassName = pros.getProperty(beanName);
//            T t;
//            if (beans.get(beanName)==null){
//                t = (T) clazz.forName(beanClassName).newInstance();
//                beans.put(beanName,t);
//            }else {
//                t = (T) beans.get(beanName);
//            }
//            System.out.println(t);
//            return t;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        throw new RuntimeException("未获取到Bean对象");
//    }

}
