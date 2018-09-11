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

@WebServlet("/DeleteOrder")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("order_id");
        int order_id = Integer.parseInt(oid);
        Order order = new Order();
        order.setOrder_id(order_id);
        OrderDao orderDao = new OrderDaoImpl();
        int ret = orderDao.deleteOrder(order);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
