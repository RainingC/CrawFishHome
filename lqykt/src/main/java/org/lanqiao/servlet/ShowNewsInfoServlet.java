package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.NewsDao;
import org.lanqiao.dao.NewsDaoImpl;
import org.lanqiao.entity.News;
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

@WebServlet("/ShowNewsInfoServlet")
public class ShowNewsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pagNum =1 ;
        int i1 = Integer.parseInt(request.getParameter("userid"));
        String num = request.getParameter("num");
        if (num != null && !num.equals("")){
            pagNum = Integer.parseInt(num);
        }
        NewsDao newsDao = new NewsDaoImpl();//用ShowNewsInfo方法
        List<News> list = newsDao.ShowNewsInfo(i1,pagNum,5);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());

        JSONArray josnarray1 = JSONArray.fromObject(list,jsonConfig);
        josnarray1.add(newsDao.GetNewsCount(i1));
        PrintWriter out=response.getWriter();
        out.print(josnarray1);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
