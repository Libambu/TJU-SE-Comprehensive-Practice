package com.neusoft.elm.dao.Impl;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class BusinessDaoImpl implements BusinessDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    @Override
    public java.util.List<Business> listBusinessByOrderTypeId(Integer orderTypeId) throws Exception {
        List<Business> list = new ArrayList<>();
        String sql = "select * from business where orderTypeId = ? order by businessId" ;
        try{
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderTypeId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setRemarks(rs.getString("remarks"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        }finally{
            DBUtil.close(rs, pst);
        }
        return list;
    }
    @Override
    public Business getBusinessById(Integer businessId) throws Exception{
        Business business = null;
        String sql = "select * from business where businessId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, businessId);
            rs = pst.executeQuery();
            while(rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
            }
        }finally {
            DBUtil.close(rs,pst);
        }
        return business;
    }
}
