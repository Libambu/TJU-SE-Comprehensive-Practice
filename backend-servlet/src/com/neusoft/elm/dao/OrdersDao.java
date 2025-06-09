package com.neusoft.elm.dao;
import java.util.List;
import com.neusoft.elm.po.Orders;
public interface OrdersDao {
    public int saveOrders(Orders orders) throws Exception;
    public Orders getOrdersById(Integer orderId) throws Exception;
    public List<Orders> listOrdersByUserId(String userId) throws Exception;
}