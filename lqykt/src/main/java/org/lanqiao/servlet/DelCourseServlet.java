package org.lanqiao.servlet;

import org.lanqiao.dao.CourseDaoImpl;
import org.lanqiao.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DelCourse")
public class DelCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取数据
        String courseId = request.getParameter("courseId");
        if(!courseId.equals("") && courseId!=null){
            int id = Integer.parseInt(courseId);
            // 封装数据
            Course c = new Course();
            c.setCourse_id(id);
            // dao操作
            int rst = new CourseDaoImpl().delete(c);
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
