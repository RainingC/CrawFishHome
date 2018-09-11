package org.lanqiao.dao;

import org.lanqiao.entity.MyOrder;
import org.lanqiao.entity.Order;

import java.util.List;

public interface MyOrderDao {
    public List<MyOrder> showMyOrder(Order order);
    public List<MyOrder> showUserOrder();
}
