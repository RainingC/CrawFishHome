package org.lanqiao.servlet;

import org.lanqiao.dao.CartDao;
import org.lanqiao.dao.CartDaoImpl;
import org.lanqiao.entity.Cart;
import org.lanqiao.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/InsertUserCrouseId")
public class InsertUserCrouseIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得课程用户id
        String courseid = request.getParameter("courseId");
        String userid = request.getParameter("userId");
        int course_id = Integer.parseInt(courseid);
        int user_id = Integer.parseInt(userid);
        //封装
        Cart cart = new Cart();
        cart.setUser_id(user_id);
        cart.setCourse_id(course_id);
        CartDao cartDao = new CartDaoImpl();
        PrintWriter out = response.getWriter();
        //检查某一用户购物车中是否有这门课程 如果没有i=0
        int i = cartDao.check(cart);
        int ret = 0;
        if (i == 0) {
            ret = cartDao.insertCartInfo(cart);
            out.print(ret);
        }else {
            out.print(ret);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
