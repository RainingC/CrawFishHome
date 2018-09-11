package org.lanqiao.servlet;

import org.lanqiao.Dao.userDao;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/addUser")
public class InsertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得表单数据
        String username1=request.getParameter("username");
        String messages=request.getParameter("msg");

        System.out.println(username1);
        //封装对象
        User user=new User(username1,messages);
        //进行Dao操作
        int ret=new userDao().addUser(user);
        System.out.println(ret);
        //输出操作
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
