package com.czh.DIYMyBatis.SqlSenssion.Impl;

import com.czh.DIYMyBatis.Config.Configuration;
import com.czh.DIYMyBatis.Mapper.Mapper;
import com.czh.DIYMyBatis.utils.Executor;
import com.czh.DIYMyBatis.utils.JDBCUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;

/**
 * @author zhCoding
 * @Description:
 * @create 14:25
 */
public class ProxyObject implements InvocationHandler {

    private Configuration cfg;
    private Connection conn;

    public ProxyObject(Configuration cfg, Connection conn) {
        this.cfg = cfg;
        this.conn = conn;
    }


    /**
     * 在代理对象中具体实现dao接口中的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();

        String key = className+"."+methodName;




        Executor executor = new Executor();

        Mapper mapper = cfg.getMappers().get(key);
        if (mapper == null)  throw new RuntimeException("传入参数为空！");

        return executor.selectList(mapper, conn);
    }
}
