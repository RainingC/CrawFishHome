package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.PeriodDao;
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

@WebServlet("/ShowPeriodServlet")
public class ShowPeriodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得表单数据
        String courseId = request.getParameter("course_id");
        int course_id = Integer.parseInt(courseId);
        // 2.封装对象
        PeriodDao periodDao = new PeriodDaoImpl();
        List<Period> list = periodDao.select(course_id);
        // 3.进行Dao操作
        JSONArray josnarray = JSONArray.fromObject(list);
        // 4.输出操作
        PrintWriter out=response.getWriter();
        out.print(josnarray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
