package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.PeriodDaoImpl;
import org.lanqiao.entity.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowPeriod")
public class ShowPeriodPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取课程名
        String courseId = request.getParameter("courseId");
        if(courseId!=null && !courseId.equals("")){
            int id = Integer.parseInt(courseId);
            // 封装数据
            Period p = new Period();
            p.setCourse_id(id);
            // dao操作
            List<Period> list = new PeriodDaoImpl().select(p);
            // 返回数据
            PrintWriter pw = response.getWriter();
            pw.print(JSONArray.fromObject(list));
            pw.flush();
            pw.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
