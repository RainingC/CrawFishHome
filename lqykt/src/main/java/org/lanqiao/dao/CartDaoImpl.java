package org.lanqiao.dao;

import org.lanqiao.entity.Cart;
import org.lanqiao.entity.Course;

import java.util.List;

public class CartDaoImpl extends BaseDao<Cart> implements CartDao {
    //    public Cart showCartInfo(Cart cart){
//        List<Cart> cartList = executeQuery("select * from cart where user_id = ?",new Object[]{cart.getUser_id()});
//        return  cartList.get(0);
//    }
    public int insertCartInfo(Cart cart) {
        return executeUpdate("insert into cart(user_id,course_id) values(?,?)", new Object[]{cart.getUser_id(), cart.getCourse_id()});
    }

    public int check(Cart cart) {
        int userid = cart.getUser_id();
        int courseid = cart.getCourse_id();
        return getRecordCount("SELECT COUNT(course_id)  from cart where user_id = "+userid+" and course_id= "+courseid);
    }

    public int deleteCourse(Cart cart){
        return executeUpdate("delete from cart where user_id=? and course_id=?",new Object[]{cart.getUser_id(),cart.getCourse_id()});
    }

    public int cartCourseNum(Cart cart){
        int userid = cart.getUser_id();
        return getRecordCount("select COUNT(course_id)from cart where user_id = "+userid);
    }


}