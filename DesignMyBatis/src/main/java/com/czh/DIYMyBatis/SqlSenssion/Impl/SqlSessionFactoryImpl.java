package com.czh.DIYMyBatis.SqlSenssion.Impl;

import com.czh.DIYMyBatis.Config.Configuration;
import com.czh.DIYMyBatis.SqlSenssion.SqlSession;
import com.czh.DIYMyBatis.SqlSenssion.SqlSessionFactory;

/**
 * @author zhCoding
 * @Description:
 * @create 14:51
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {

    private Configuration cfg;

    public SqlSessionFactoryImpl(Configuration cfg){
        this.cfg = cfg;
    }

    @Override
    public SqlSession openSession() {
        return new SqlSessionImpl(cfg);
    }
}
