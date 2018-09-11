package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.CourseDao;
import org.lanqiao.dao.CourseDaoImpl;
import org.lanqiao.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowSearchInfoServlet")
public class ShowSearchInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得数据
        String val = request.getParameter("searchinfo");
        //实例化
        CourseDao courseDao = new CourseDaoImpl();
        //实现方法并传入获得的数据
        List<Course> list = courseDao.ShowPrompt(val);
        //封装返回的集合并传出
        JSONArray josnarray1 = JSONArray.fromObject(list);
        PrintWriter out=response.getWriter();
        out.print(josnarray1);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
