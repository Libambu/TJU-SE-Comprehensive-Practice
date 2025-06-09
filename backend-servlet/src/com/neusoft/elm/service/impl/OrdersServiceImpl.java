package com.neusoft.elm.service.impl;
import java.util.ArrayList;
import java.util.List;
import com.neusoft.elm.dao.CartDao;
import com.neusoft.elm.dao.OrderDetailetDao;
import com.neusoft.elm.dao.OrdersDao;
import com.neusoft.elm.dao.Impl.CartDaoImpl;
import com.neusoft.elm.dao.Impl.OrderDetailetDaoImpl;
import com.neusoft.elm.dao.Impl.OrdersDaoImpl;
import com.neusoft.elm.po.Cart;
import com.neusoft.elm.po.OrderDetailet;
import com.neusoft.elm.po.Orders;
import com.neusoft.elm.service.OrdersService;
import com.neusoft.elm.util.DBUtil;
public class OrdersServiceImpl implements OrdersService{
    @Override
    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal)
    {
        int orderId = 0;
        CartDao cartDao = new CartDaoImpl();
        OrdersDao ordersDao = new OrdersDaoImpl();
        OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();
        try {
            DBUtil.beginTransaction(); //开启一个事务
        //1、查询当前用户购物车中当前商家的所有食品（目的是放入订单明细中）
            Cart cart = new Cart();
            cart.setUserId(userId);
            cart.setBusinessId(businessId);
            List<Cart> cartList = cartDao.listCart(cart);
        //2、创建订单，并获取订单编号
            Orders orders = new Orders();
            orders.setUserId(userId);
            orders.setBusinessId(businessId);
            orders.setDaId(daId);
            orders.setOrderTotal(orderTotal);
            orderId = ordersDao.saveOrders(orders);
        //3、向订单明细表中批量添加明细数据
            List<OrderDetailet> orderDetailetList = new ArrayList();
            for(Cart c : cartList) {
                OrderDetailet od = new OrderDetailet();
                od.setOrderId(orderId);
                od.setFoodId(c.getFoodId());
                od.setQuantity(c.getQuantity());
                orderDetailetList.add(od);
            }
            orderDetailetDao.saveOrderDetailetBatch(orderDetailetList);
        //4、清空购物车（条件：当前用户、当前商家）
            cartDao.removeCart(cart);
            DBUtil.commitTransaction(); //提交一个事务
        }catch (Exception e) {
            orderId = 0;
            try {
                DBUtil.rollbackTransaction(); //回滚一个事务
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return orderId;
    }
    @Override
    public Orders getOrdersById(Integer orderId) {
        Orders orders = null;
        OrdersDao ordersDao = new OrdersDaoImpl();
        OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();
        try {
            DBUtil.getConnection();
    //1、根据订单ID查询订单信息（多对一：商家）
            orders = ordersDao.getOrdersById(orderId);
    //2、根据订单ID查询订单明细信息
            List<OrderDetailet> list = orderDetailetDao.listOrderDetailetByOrderId(orderId);
            orders.setList(list);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return orders;
    }
    @Override
    public List<Orders> listOrdersByUserId(String userId){
        List<Orders> list = new ArrayList<>();
        OrdersDao ordersDao = new OrdersDaoImpl();
        OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();
        try {
            DBUtil.getConnection();
//1、根据用户ID查询订单信息（多对一：商家）
            list = ordersDao.listOrdersByUserId(userId);
//2、查询多个订单的订单明细信息
            for(Orders o : list) {
                List<OrderDetailet> odList =
                        orderDetailetDao.listOrderDetailetByOrderId(o.getOrderId());
                o.setList(odList);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }
}