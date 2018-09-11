package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.CourseDaoImpl;
import org.lanqiao.dao.CourseKindDaoImpl;
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

@WebServlet("/ShowKind")
public class ShowKindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取课程名
        String name = request.getParameter("name");
//        System.out.println(name);

        // 封装数据
        CourseKind ck = new CourseKind();
        ck.setKind_name(name);
        // dao操作
        List<CourseKind> list = new CourseKindDaoImpl().select(ck);
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
