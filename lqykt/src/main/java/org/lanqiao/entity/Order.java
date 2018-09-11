package org.lanqiao.entity;

import java.util.Date;

public class Order {
//    private int cart_id;
    private String course_name;
    private int order_id;
    private int user_id;
    private int course_id;
    private Date order_time;
    private int order_status;
    private int kind_id;

    public Order(){

    };
    public Order(int user_id, int course_id, String course_name) {
        this.user_id = user_id;
        this.course_id = course_id;
//        this.cart_id = cart_id;
        this.course_name = course_name;
    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }
}
