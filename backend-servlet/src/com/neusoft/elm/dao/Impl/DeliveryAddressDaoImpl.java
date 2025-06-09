package com.neusoft.elm.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.neusoft.elm.dao.DeliveryAddressDao;
import com.neusoft.elm.po.DeliveryAddress;
import com.neusoft.elm.util.DBUtil;
public class DeliveryAddressDaoImpl implements DeliveryAddressDao{
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) throws Exception {
        List<DeliveryAddress> list = new ArrayList<>();
        String sql = "select * from deliveryAddress where userId=? order by daId";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            rs = pst.executeQuery();
            while(rs.next()) {
                DeliveryAddress deliveryAddress = new DeliveryAddress();
                deliveryAddress.setDaId(rs.getInt("daId"));
                deliveryAddress.setContactName(rs.getString("contactName"));
                deliveryAddress.setContactSex(rs.getInt("contactSex"));
                deliveryAddress.setContactTel(rs.getString("contactTel"));
                deliveryAddress.setAddress(rs.getString("address"));
                deliveryAddress.setUserId(rs.getString("userId"));
                list.add(deliveryAddress);
            }
        }finally {
            DBUtil.close(rs,pst);
        }
        return list;
    }
    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception{
        int result = 0;
        String sql = "insert into deliveryAddress values(null,?,?,?,?,?)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, deliveryAddress.getContactName());
            pst.setInt(2, deliveryAddress.getContactSex());
            pst.setString(3, deliveryAddress.getContactTel());
            pst.setString(4, deliveryAddress.getAddress());
            pst.setString(5, deliveryAddress.getUserId());
            result = pst.executeUpdate();
        }finally {
            DBUtil.close(rs,pst);
        }
        return result;
    }
    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) throws Exception{
        DeliveryAddress deliveryAddress = null;
        String sql = "select * from deliveryAddress where daId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, daId);
            rs = pst.executeQuery();
            while(rs.next()) {
                deliveryAddress = new DeliveryAddress();
                deliveryAddress.setDaId(rs.getInt("daId"));
                deliveryAddress.setContactName(rs.getString("contactName"));
                deliveryAddress.setContactSex(rs.getInt("contactSex"));
                deliveryAddress.setContactTel(rs.getString("contactTel"));
                deliveryAddress.setAddress(rs.getString("address"));
                deliveryAddress.setUserId(rs.getString("userId"));
            }
        }finally {
            DBUtil.close(rs,pst);
        }
        return deliveryAddress;
    }
    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception{
        int result = 0;
        String sql = "update deliveryAddress set contactName=?,contactSex=?,contactTel=?,address=? where daId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, deliveryAddress.getContactName());
            pst.setInt(2, deliveryAddress.getContactSex());
            pst.setString(3, deliveryAddress.getContactTel());
            pst.setString(4, deliveryAddress.getAddress());
            pst.setInt(5, deliveryAddress.getDaId());
            result = pst.executeUpdate();
        }finally {
            DBUtil.close(rs,pst);
        }
        return result;
    }
    @Override
    public int removeDeliveryAddress(Integer daId) throws Exception{
        int result = 0;
        String sql = "delete from deliveryAddress where daId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, daId);
            result = pst.executeUpdate();
        }finally {
            DBUtil.close(rs,pst);
        }
        return result;
    }
}

