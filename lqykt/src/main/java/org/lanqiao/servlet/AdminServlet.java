package org.lanqiao.servlet;


import net.sf.json.JSONArray;
import org.lanqiao.dao.AdminDao;
import org.lanqiao.dao.AdminDaoImpl;
import org.lanqiao.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("admin");
        String pwd = request.getParameter("password");
        Admin admin = new Admin(user, pwd);
        AdminDao adminDao = new AdminDaoImpl();
        List<Admin> list = adminDao.checkAdmin(admin);
        PrintWriter out=response.getWriter();
        JSONArray json1=JSONArray.fromObject(list);
        System.out.println(json1);
        if(json1.size()>0)
        {
            out.print(json1);
        }else
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
