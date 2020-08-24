package com.czh.DIYMyBatis.utils;

import com.czh.DIYMyBatis.Config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zhCoding
 * @Description:
 * @create 15:01
 */
public class JDBCUtils {

    public static Connection getConnection(Configuration cfg){

        Connection conn = null;
        try {
            JDBCUtils.class.forName(cfg.getDriver());

            conn = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void closeConn(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
