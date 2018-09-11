package org.lanqiao.servlet;


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

@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone=request.getParameter("userphone");
        String pwd=request.getParameter("userpwd");
        System.out.println(phone);
        User user=new User();
        user.setUser_phone(phone);
        user.setUser_pwd(pwd);
        UserDao userDao = new UserDaoImpl();
        List<User> list=userDao.select(user);
        System.out.println(list.size());
        PrintWriter out=response.getWriter();
        if(list.size()>0)
        {
            System.out.println(list.size());
            out.print(0);
        }else
        {
            int ret=userDao.addUser(user);
            System.out.println(ret);
            out.print(ret);
        }
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
