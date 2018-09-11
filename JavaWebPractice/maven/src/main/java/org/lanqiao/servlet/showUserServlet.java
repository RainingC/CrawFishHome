package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.Dao.userDao;
import org.lanqiao.entity.User;
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

@WebServlet("/showUser")
public class showUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pagNum = 1;
        String num = request.getParameter("num");
        if (num != null && !num.equals("")){
            pagNum = Integer.parseInt(num);
        }
        //dao操作
        userDao userdao = new userDao();
        List<User> list= userdao.showAllUser(pagNum,5);
        //输出操作
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());

        JSONArray josnarray = JSONArray.fromObject(list,jsonConfig);
        josnarray.add(userdao.getMsgCount());
        response.setContentType("application/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(josnarray);
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
