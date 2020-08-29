package com.czh.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author zhCoding
 * @Description: 事务管理
 * @create 14:19
 */
@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;


    public void beginTransaction(){
        try {
            connectionUtils.getThreadConn().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionUtils.getThreadConn().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtils.getThreadConn().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release(){
        connectionUtils.remove();
    }

}
