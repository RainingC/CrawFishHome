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

@WebServlet("/CheckUser")
public class CheckUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone=request.getParameter("phone");
        String pwd=request.getParameter("pwd");
        User user=new User(phone,pwd);
        UserDao userDao = new UserDaoImpl();
        List<User> userList =userDao.checkUsers(user);
        PrintWriter out = response.getWriter();
        JSONArray jsone=JSONArray.fromObject(userList);
        System.out.println(jsone);
        if(jsone.size()>0)
        {
            out.print(jsone);
        }else{
            out.print(0);
        }
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
