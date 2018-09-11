package org.lanqiao.dao;

import org.lanqiao.entity.Order;
import org.lanqiao.entity.User;

import java.util.List;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao{
    //删除
    public int delete(int id) {
        return executeUpdate("delete order where order_id = ?", new Object[]{id});
    }
    //查询
    public List<Order> select(String key) {   // key是查询的关键字
        return executeQuery("select order_id, user_id, course_id, o" +
                        "from course where course_name like '%?%'",
                new Object[]{key});
    }

//    @Override
//    public List<Order> showCourseName(User user) {
//        return executeQuery("select course_name from course where course_id in" +
//                " (select course_id from `order` where user_id=?)", new Object[]{user.getUser_id()});
//    }
    public int insertOrderInfo(Order order){
        return executeUpdate("insert into `order`(user_id,course_id) values(?,?)",new Object[]{order.getUser_id(),order.getCourse_id()});
    }
    public int changeStatus(Order order){
        return  executeUpdate("UPDATE `order` set order_status = 1 where course_id = ? and user_id = ?",new Object[]{order.getCourse_id(),order.getUser_id()});
    }
    public int deleteOrder(Order order){
        return executeUpdate("delete from `order` where order_id = ?",new Object[]{order.getOrder_id()});
    }
}

// 查询 下单时间 订单号 交易状态
// select course_id from order
// 课程名 价格
// select course_name, price from course where course_id = ()
// 整合
/*
    select o.order_time, o.order_id, o.order_status, c.course_name, c.price
    from order o
    left outer join course c
    on (c.course_id = o.course_id)
*/

