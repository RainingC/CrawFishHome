package org.lanqiao.servlet;

import org.lanqiao.dao.CartDao;
import org.lanqiao.dao.CartDaoImpl;
import org.lanqiao.entity.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CartCourseNum")
public class CartCourseNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("user_id");
        int user_id = Integer.parseInt(uid);
        Cart cart = new Cart();
        cart.setUser_id(user_id);
        CartDao cartDao = new CartDaoImpl();
        int ret = cartDao.cartCourseNum(cart);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
