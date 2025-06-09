package com.neusoft.elm.dao.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.neusoft.elm.dao.OrdersDao;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.po.Orders;
import com.neusoft.elm.util.CommonUtil;
import com.neusoft.elm.util.DBUtil;
public class OrdersDaoImpl implements OrdersDao{
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    @Override
    public int saveOrders(Orders orders) throws Exception {
        int orderId = 0;
        String sql = "insert into orders values(null,?,?,?,?,?,0)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, orders.getUserId());
            pst.setInt(2, orders.getBusinessId());
            pst.setString(3, CommonUtil.getCurrentDate());
            pst.setDouble(4, orders.getOrderTotal());
            pst.setInt(5, orders.getDaId());
            pst.executeUpdate();
//获取自增长列值（一行一列）
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                orderId = rs.getInt(1);
            }
        }finally {
            DBUtil.close(pst);
        }
        return orderId;
    }
    @Override
    public Orders getOrdersById(Integer orderId) throws Exception{
        Orders orders = null;
        StringBuffer sql = new StringBuffer();
        sql.append(" select o.*, ");
        sql.append(" b.businessId bbusinessId, ");
        sql.append(" b.businessName bbusinessName, ");
        sql.append(" b.deliveryPrice bdeliveryPrice ");
        sql.append(" from orders o left join business b on o.businessId=b.businessId ");
        sql.append(" where o.orderId=? ");
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, orderId);
            rs = pst.executeQuery();
            while(rs.next()) {
                orders = new Orders();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessId(rs.getInt("businessId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setDaId(rs.getInt("daId"));
                orders.setOrderState(rs.getInt("orderState"));
                Business business = new Business();
                business.setBusinessId(rs.getInt("bbusinessId"));
                business.setBusinessName(rs.getString("bbusinessName"));
                business.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                orders.setBusiness(business);
            }
        }finally {
            DBUtil.close(pst);
        }
        return orders;
    }
    @Override
    public List<Orders> listOrdersByUserId(String userId) throws Exception{
        List<Orders> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer();
        sql.append(" select o.*, ");
        sql.append(" b.businessId bbusinessId, ");
        sql.append(" b.businessName bbusinessName, ");
        sql.append(" b.deliveryPrice bdeliveryPrice ");
        sql.append(" from orders o left join business b on o.businessId=b.businessId ");
        sql.append(" where o.userId=? ");
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1, userId);
            rs = pst.executeQuery();
            while(rs.next()) {
                Orders orders = new Orders();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessId(rs.getInt("businessId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setDaId(rs.getInt("daId"));
                orders.setOrderState(rs.getInt("orderState"));
                Business business = new Business();
                business.setBusinessId(rs.getInt("bbusinessId"));
                business.setBusinessName(rs.getString("bbusinessName"));
                business.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                orders.setBusiness(business);
                list.add(orders);
            }
        }finally {
            DBUtil.close(pst);
        }
        return list;
    }
}