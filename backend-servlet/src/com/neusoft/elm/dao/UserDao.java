package com.neusoft.elm.dao;
import com.neusoft.elm.po.User;
public interface UserDao {
    public User getUserByIdByPass(String userId,String password) throws Exception;
    public int getUserById(String userId) throws Exception;
    public int saveUser(User user) throws Exception;
}