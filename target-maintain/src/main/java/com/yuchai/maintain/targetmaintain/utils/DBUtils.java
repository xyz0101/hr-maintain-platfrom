package com.yuchai.maintain.targetmaintain.utils;

import java.sql.*;

public class DBUtils {
    public static Connection getConnection(){
        try {
            Class clazz = Class.forName("oracle.jdbc.driver.OracleDriver");
            String user = "portal";
            String password="portal";
            String url = "jdbc:oracle:thin:@172.16.90.66:1521/dbtst";
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeAll(Connection conn, Statement stat, ResultSet rs){
        try {
            if (conn == null) {
                conn = null;
            } else {
                conn.close();
            }
            if (stat == null) {
                stat = null;
            } else {
                stat.close();
            }
            if (rs == null) {
                rs = null;
            } else {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
