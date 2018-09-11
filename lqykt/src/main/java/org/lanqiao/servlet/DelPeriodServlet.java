package org.lanqiao.servlet;

import org.lanqiao.dao.CourseDaoImpl;
import org.lanqiao.dao.PeriodDaoImpl;
import org.lanqiao.entity.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DelPeriod")
public class DelPeriodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取数据
        String p_id = request.getParameter("id");
        if(!p_id.equals("") && p_id!=null){
            int id = Integer.parseInt(p_id);
            System.out.println(id);
            // 封装数据
            Period p = new Period();
            p.setId(id);
            // dao操作
            int rst = new PeriodDaoImpl().delete(p);
            System.out.println(rst);
            // 返回数据
            PrintWriter pw = response.getWriter();
            pw.print(rst);
            pw.flush();
            pw.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
