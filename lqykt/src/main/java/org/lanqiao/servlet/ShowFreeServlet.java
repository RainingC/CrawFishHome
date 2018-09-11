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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowFreeServlet")
public class ShowFreeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDao courseDao = new CourseDaoImpl();

        List<Course> list = courseDao.ShowFreeCourse();
        List<Course> list1 = new ArrayList();
        for (int i=0;i<5;i++){
            list1.add(list.get(i));
        }
        JSONArray josnarray1 = JSONArray.fromObject(list1);
        PrintWriter out=response.getWriter();
        out.print(josnarray1);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
