package org.lanqiao.dao;

import org.lanqiao.entity.Cart;
import org.lanqiao.entity.Course;

import java.util.List;

public interface CartDao {

    public int insertCartInfo(Cart cart);
    public int check(Cart cart);
    public int deleteCourse(Cart cart);
    public int cartCourseNum(Cart cart);
}
