package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.CourseDaoImpl;
import org.lanqiao.entity.Course;
import org.lanqiao.entity.CourseKind;
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

@WebServlet("/ShowAllCourse")
public class ShowAllCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取课程名
        String name = request.getParameter("two_name");
//        System.out.println(name);
        // 封装数据
        CourseKind ck = new CourseKind();
        ck.setKind_name(name);
        // dao操作
        List<Course> list = new CourseDaoImpl().selectAll(ck);
//        System.out.println(JSONArray.fromObject(list));
        // 日期格式化
        JsonConfig jConfig = new JsonConfig();
        jConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray js = JSONArray.fromObject(list, jConfig);
        // 返回数据
        PrintWriter pw = response.getWriter();
        pw.print(js);
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
