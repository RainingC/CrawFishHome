package org.lanqiao.servlet;

import org.lanqiao.dao.UserDaoImpl;
import org.lanqiao.entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/updateUser")
public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得表单数据
         String id = request.getParameter("user_id");
      String username=request.getParameter("user_name");
      String  userqq=request.getParameter("user_qq");
      String usersex=request.getParameter("user_sex");
//      String userpicaddress =request.getParameter("user_picaddress");
      String usersignature=request.getParameter("user_signature");

        //封装对象
        User user=new User();
        user.setUser_id(Integer.parseInt(id));
        user.setUser_name(username);
       user.setUser_qq(Integer.parseInt(userqq));
     //  user.setUser_picaddress(userpicaddress);
       user.setUser_signature(usersignature);

        //进行Dao操作
        UserDaoImpl user1 = new UserDaoImpl();
        int ret=user1.updateUser(user);
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
