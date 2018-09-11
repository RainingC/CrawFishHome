package org.lanqiao.dao;

import org.lanqiao.entity.MyOrder;
import org.lanqiao.entity.Order;

import java.util.List;

public class MyOrderDaoImpl extends BaseDao<MyOrder> implements MyOrderDao{
    public List<MyOrder> showMyOrder(Order order){
        List<MyOrder> myOrderList = executeQuery("SELECT * FROM `order` ord INNER JOIN course cr ON ord.course_id=cr.course_id where user_id = ?",new Object[]{order.getUser_id()});
        return  myOrderList;
    }

    public List<MyOrder> showUserOrder(){
        List<MyOrder> myOrderList = executeQuery("SELECT order_id,order_time,price,order_status FROM course cr INNER JOIN `order` ord ON ord.course_id=cr.course_id  ");
        return  myOrderList;
    }
}
