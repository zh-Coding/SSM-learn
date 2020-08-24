package com.czh.DIYMyBatis.SqlSenssion.Impl;

import com.czh.DIYMyBatis.Config.Configuration;
import com.czh.DIYMyBatis.SqlSenssion.SqlSession;
import com.czh.DIYMyBatis.utils.JDBCUtils;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhCoding
 * @Description:
 * @create 14:54
 */
public class SqlSessionImpl implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        this.conn = JDBCUtils.getConnection(cfg);
    }

    /**
     * 创建接口代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return  (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new ProxyObject(cfg,conn));
    }

    /**
     * 关闭资源
     */
    @Override
    public void closer() {
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
