package com.czh.DIYMyBatis.SqlSenssion;

/**
 * @author zhCoding
 * @Description:
 * @create 13:57
 */
public interface SqlSessionFactory {

    /**
     * 打开一个会话并获取SqlSession对象
     * @return
     */
    SqlSession openSession();

}
