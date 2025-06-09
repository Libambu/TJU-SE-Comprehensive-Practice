package com.neusoft.elm.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBUtil {
    private static final ThreadLocal<Connection> TL = new ThreadLocal<Connection>();
    private static final String URL="jdbc:mysql://localhost:3306/elm?characterEncoding=utf-8";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String USERNAME="root";
    private static final String PASSWORD="egco711.";
    // 获取Connection
    public static Connection getConnection() {
        Connection con = null;
        con = TL.get();
        if (con==null) {
            con = createConnection();
            TL.set(con);
        }
        return con;
    }
    // 开启一个事务
    public static void beginTransaction() throws Exception {
        Connection con = null;
        con = TL.get();
        if (con == null) {
            con = createConnection();
            TL.set(con);
        }
        con.setAutoCommit(false);
    }
    // 提交一个事务
    public static void commitTransaction() throws Exception {
        Connection con = TL.get();
        con.commit();
    }
    // 回滚一个事务
    public static void rollbackTransaction() throws Exception {
        Connection con = TL.get();
        con.rollback();
    }
    // 关闭各种资源
    public static void close(ResultSet rs, PreparedStatement pst) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 关闭各种资源
    public static void close(PreparedStatement pst) {
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 关闭各种资源
    public static void close() {
        Connection con = TL.get();
        try {
            if (con != null) {
                con.close();
            }
//至关重要，否则容易造成内存溢出等问题。
            TL.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static Connection createConnection() {
        Connection con = null;
        if (con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}