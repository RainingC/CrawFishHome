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

@WebServlet("/ShowCourseServlet")
public class ShowCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得表单数据
        String courseId = request.getParameter("course_id");
        int course_id = Integer.parseInt(courseId);
        // 2.封装对象
        Course course = new Course();
        course.setCourse_id(course_id);
        CourseDao courseDao = new CourseDaoImpl();
        List<Course> list= courseDao.selectid(course);
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
