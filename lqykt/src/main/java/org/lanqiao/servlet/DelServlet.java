package org.lanqiao.servlet;


import org.lanqiao.dao.DelectDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/DelServlet")
public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        System.out.println(user_id);
        if(user_id!=null && !user_id.equals("")){
            int id = Integer.parseInt(user_id);
            System.out.println(id);
            User user=new User();
            user.setUser_id(id);
            int ret=new DelectDaoImpl().delectuser(user);
            PrintWriter out=response.getWriter();
            out.print(ret);
            out.flush();
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
