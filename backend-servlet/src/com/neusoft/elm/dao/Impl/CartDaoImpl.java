package com.neusoft.elm.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.neusoft.elm.dao.CartDao;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.po.Cart;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.util.DBUtil;
public class CartDaoImpl implements CartDao{
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    @Override
    public int saveCart(Cart cart) throws Exception {
        int result = 0;
        String sql = "insert into cart values(null,?,?,?,1)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, cart.getFoodId());
            pst.setInt(2, cart.getBusinessId());
            pst.setString(3, cart.getUserId());
            result = pst.executeUpdate();
        }finally {
            DBUtil.close(pst);
        }
        return result;
    }
    @Override
    public int updateCart(Cart cart) throws Exception{
        int result = 0;
        String sql = "update cart set quantity=? where userId=? and businessId=? and foodId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, cart.getQuantity());
            pst.setString(2, cart.getUserId());
            pst.setInt(3, cart.getBusinessId());
            pst.setInt(4, cart.getFoodId());
            result = pst.executeUpdate();
        }finally {
            DBUtil.close(pst);
        }
        return result;
    }
    @Override
    public int removeCart(Cart cart) throws Exception{
        int result = 0;
        StringBuffer sql = new StringBuffer("delete from cart where userId=? and businessId=?");
        if(cart.getFoodId()!=null) {
            sql.append(" and foodId="+cart.getFoodId());
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1, cart.getUserId());
            pst.setInt(2, cart.getBusinessId());
            result = pst.executeUpdate();
        }finally {
            DBUtil.close(pst);
        }
        return result;
    }
    @Override
    public List<Cart> listCart(Cart cart) throws Exception{
        List<Cart> list = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append(" select c.*, ");
        sql.append(" f.foodId ffoodId, ");
        sql.append(" f.foodName ffoodName, ");
        sql.append(" f.foodExplain ffoodExplain, ");
        sql.append(" f.foodImg ffoodImg, ");
        sql.append(" f.foodPrice ffoodPrice, ");
        sql.append(" f.businessId fbusinessId, ");
        sql.append(" f.remarks fremarks, ");
        sql.append(" b.businessId bbusinessId, ");
        sql.append(" b.businessName bbusinessName, ");
        sql.append(" b.businessAddress bbusinessAddress, ");
        sql.append(" b.businessExplain bbusinessExplain, ");
        sql.append(" b.businessImg bbusinessImg, ");
        sql.append(" b.orderTypeId borderTypeId, ");
        sql.append(" b.starPrice bstarPrice, ");
        sql.append(" b.deliveryPrice bdeliveryPrice, ");
        sql.append(" b.remarks bremarks ");
        sql.append(" from (cart c left join food f on c.foodId=f.foodId) ");
        sql.append(" left join business b on c.businessId=b.businessId ");
        sql.append(" where c.userId=? ");
        if(cart.getBusinessId()!=null) {
            sql.append(" and c.businessId="+cart.getBusinessId());
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1, cart.getUserId());
            rs = pst.executeQuery();
            while(rs.next()) {
                Cart c = new Cart();
                c.setCartId(rs.getInt("cartId"));
                c.setFoodId(rs.getInt("foodId"));
                c.setBusinessId(rs.getInt("businessId"));
                c.setUserId(rs.getString("userId"));
                c.setQuantity(rs.getInt("quantity"));
                Food food = new Food();
                food.setFoodId(rs.getInt("ffoodId"));
                food.setFoodName(rs.getString("ffoodName"));
                food.setFoodExplain(rs.getString("ffoodExplain"));
                food.setFoodImg(rs.getString("ffoodImg"));
                food.setFoodPrice(rs.getDouble("ffoodPrice"));
                food.setBusinessId(rs.getInt("fbusinessId"));
                food.setRemarks(rs.getString("fremarks"));
                c.setFood(food);
                Business business = new Business();
                business.setBusinessId(rs.getInt("bbusinessId"));
                business.setBusinessName(rs.getString("bbusinessName"));
                business.setBusinessAddress(rs.getString("bbusinessAddress"));
                business.setBusinessExplain(rs.getString("bbusinessExplain"));
                business.setBusinessImg(rs.getString("bbusinessImg"));
                business.setOrderTypeId(rs.getInt("borderTypeId"));
                business.setStarPrice(rs.getDouble("bstarPrice"));
                business.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                business.setRemarks(rs.getString("bremarks"));
                c.setBusiness(business);
                list.add(c);
            }
        }finally {
            DBUtil.close(pst);
        }
        return list;
    }
}