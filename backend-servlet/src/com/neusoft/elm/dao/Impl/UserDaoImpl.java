package com.neusoft.elm.dao.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import com.neusoft.elm.dao.UserDao;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.po.User;
import com.neusoft.elm.util.DBUtil;

public class UserDaoImpl implements UserDao{
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    @Override
    public User getUserByIdByPass(String userId, String password) throws Exception {
        User user = null;
        String sql = "select * from user where userId=? and password=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while(rs.next()) {
                user = new User();
                user.setUserId(rs.getString("userId"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("userName"));
                user.setUserSex(rs.getInt("userSex"));
                user.setUserImg(rs.getString("userImg"));
                user.setDelTag(rs.getInt("delTag"));
            }
        }finally {
            DBUtil.close(rs,pst);
        }
        return user;
    }
    @Override
    public int getUserById(String userId) throws Exception{
        int result = 0;
        String sql = "select count(*) from user where userId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            rs = pst.executeQuery();
            if(rs.next()) {
                result = rs.getInt(1);
            }
        }finally {
            DBUtil.close(rs,pst);
        }
        return result;
    }
    @Override
    public int saveUser(User user) throws Exception{
        int result = 0;
        String sql = "insert into user values(?,?,?,?,?,1)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getUserId());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getUserName());
            pst.setInt(4, user.getUserSex());
            pst.setString(5, user.getUserImg());
            result = pst.executeUpdate();
        }finally {
            DBUtil.close(rs,pst);
        }
        return result;
    }
}
