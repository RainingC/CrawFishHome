package org.lanqiao.servlet;


import net.sf.json.JSONArray;
import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.UserDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/NodeServlet")
public class NodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone=request.getParameter("phone");
        User user=new User();
        user.setUser_phone(phone);
        UserDao userDao=new UserDaoImpl();
        List<User> list=userDao.select(user);
        JSONArray json1= JSONArray.fromObject(list);
        PrintWriter out=response.getWriter();
        if(json1.size()>0)
        {
            out.print(json1);
        }
        else
        {
            out.print(0);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
