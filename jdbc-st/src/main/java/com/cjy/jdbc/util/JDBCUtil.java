package com.cjy.jdbc.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/tsbds?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 查询
     * @return
     */
    public static Integer queryCount(){
        Connection conn = JDBCUtil.getConnection();
        Integer count = 0;
        String sql = "SELECT COUNT(*) FROM t_data";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            res.next();
            count = res.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return count;
    }

    /**
     * 查询
     */
    public static void queryLimit(){
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT id,dwmc,CODE,VALUE FROM t_data LIMIT 0,10";//分页数据

        PreparedStatement pre = null;
        try {
            pre = conn.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String dwmc = resultSet.getString(2);
                String code = resultSet.getString(3);
                String value = resultSet.getString(4);
                System.out.println(id +"\t"+dwmc+"\t"+code+"\t"+value);
            }
            resultSet.close();
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 插入
     */
    public static void insert(){
        Connection conn = JDBCUtil.getConnection();
        String sql = "INSERT INTO data_res(CODE,COUNT,SUM) VALUES(?,?,?);";
        PreparedStatement pre = null;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1,"sr01");
            pre.setInt(2,10);
            pre.setInt(3,20);
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pre != null){
                try {
                    pre.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //导入依赖测试链接
        System.out.println(getConnection());
        System.out.println(queryCount());
        queryLimit();
        insert();
    }
}
