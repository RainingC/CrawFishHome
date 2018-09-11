package org.lanqiao.servlet;

import org.lanqiao.dao.OrderDao;
import org.lanqiao.dao.OrderDaoImpl;
import org.lanqiao.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InserCourseToOrder")
public class InserCourseToOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("user_id");
        String cid = request.getParameter("course_id");
        int user_id = Integer.parseInt(uid);
        int course_id = Integer.parseInt(cid);
        Order order = new Order();
        order.setUser_id(user_id);
        order.setCourse_id(course_id);
        OrderDao orderDao = new OrderDaoImpl();
        int ret = orderDao.insertOrderInfo(order);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
