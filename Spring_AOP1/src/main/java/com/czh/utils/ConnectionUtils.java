package com.czh.utils;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhCoding
 * @Description: 连接工具类
 * @create 13:47
 */
@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> tconn = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;


    public Connection getThreadConn() {
        try {
            Connection conn = tconn.get();
            if (conn == null) {
                Connection conn1 = dataSource.getConnection();
                tconn.set(conn1);
                return conn1;
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void remove(){
        try {
            Connection conn = tconn.get();
            if (conn!=null){
                conn.setAutoCommit(true);
                conn.close();
            }
            tconn.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
