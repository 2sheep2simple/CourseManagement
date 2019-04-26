package com.course.util;

import com.mchange.v2.c3p0.*;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;

public class C3P0Util {

    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource=new ComboPooledDataSource("mysql");

    //从连接池中取用一个连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //释放连接回连接池
    public static void close(Connection conn,PreparedStatement pst,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}