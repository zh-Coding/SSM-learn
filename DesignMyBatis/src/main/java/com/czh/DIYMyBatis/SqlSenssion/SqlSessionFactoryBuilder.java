package com.czh.DIYMyBatis.SqlSenssion;

import com.czh.DIYMyBatis.Config.Configuration;
import com.czh.DIYMyBatis.SqlSenssion.Impl.SqlSessionFactoryImpl;
import com.czh.DIYMyBatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 工厂构建者
 * @author zhCoding
 * @Description:
 * @create 13:56
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream is){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(is);
        return new SqlSessionFactoryImpl(cfg);
    }

}
