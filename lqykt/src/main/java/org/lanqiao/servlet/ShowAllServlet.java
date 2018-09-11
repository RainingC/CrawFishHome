package org.lanqiao.servlet;


import net.sf.json.JSONArray;
import org.lanqiao.dao.DelectDao;
import org.lanqiao.dao.DelectDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String user_id=request.getParameter("user_id");
//        String user_phone=request.getParameter("user_phone");
        DelectDao delectDao=new DelectDaoImpl();
        List<User> list=delectDao.selectAll();
        JSONArray jsone=JSONArray.fromObject(list);
        System.out.println(jsone);
        PrintWriter out=response.getWriter();
        out.print(jsone);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
