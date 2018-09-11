package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.CourseDaoImpl;
import org.lanqiao.entity.Course;
import org.lanqiao.entity.CourseKind;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowSignleCourse")
public class ShowSignleCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取课程名
        String name = request.getParameter("two_name");
        // 获取页码
        String pageBegin = request.getParameter("pageBegin");
        int begin = Integer.parseInt(pageBegin);
        String pageSize = request.getParameter("pageSize");
        int size = Integer.parseInt(pageSize);
//        System.out.println(name);
        // 封装数据
        CourseKind ck = new CourseKind();
        ck.setKind_name(name);
        // dao操作
        List<Course> list = new CourseDaoImpl().selectSignle(ck, (begin-1)*size, size);
//        System.out.println(JSONArray.fromObject(list));
        // 返回数据
        PrintWriter pw = response.getWriter();
        pw.print(JSONArray.fromObject(list));
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
