package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.CourseDao;
import org.lanqiao.dao.CourseDaoImpl;
import org.lanqiao.dao.MyOrderDao;
import org.lanqiao.dao.MyOrderDaoImpl;
import org.lanqiao.entity.MyOrder;
import org.lanqiao.entity.Order;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/ShowMyOrder")
public class ShowMyOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("user_id");
        int user_id = Integer.parseInt(uid);
        Order order = new Order();
        order.setUser_id(user_id);
        MyOrderDao myOrderDao = new MyOrderDaoImpl();
        List<MyOrder> myOrderList = myOrderDao.showMyOrder(order);
        //日期格式转换
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(myOrderList,jsonConfig);

        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
