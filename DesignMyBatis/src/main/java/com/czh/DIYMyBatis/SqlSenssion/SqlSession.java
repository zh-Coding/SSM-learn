package com.czh.DIYMyBatis.SqlSenssion;

import java.lang.reflect.Proxy;

/**
 * 与数据交互的核心
 * 创建dao接口的代理对象
 * @author zhCoding
 * @Description:
 * @create 14:19
 */
public interface SqlSession {

    /**
     * 创建一个dao接口的代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    void closer();
}
