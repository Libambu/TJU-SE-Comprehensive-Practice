package com.neusoft.elm.dao;
import java.util.List;
import com.neusoft.elm.po.OrderDetailet;
public interface OrderDetailetDao {
    public int saveOrderDetailetBatch(List<OrderDetailet> list) throws Exception;
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId) throws Exception;
}