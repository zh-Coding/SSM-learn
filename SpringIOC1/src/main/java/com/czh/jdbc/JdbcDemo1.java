package com.czh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author zhCoding
 * @Description:程序的耦合   耦合：程序间的依赖关系
 * @create 20:33
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis01", "root", "root");
        //3.获取操作数据库的预处理对象
        PreparedStatement ps = conn.prepareStatement("select * from account");
        //4.执行Sql，得到返回信息或结果集
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("uid"));
        }
        //5.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
