package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.CourseDao;
import org.lanqiao.dao.CourseDaoImpl;
import org.lanqiao.dao.CourseKindDao;
import org.lanqiao.dao.CourseKindDaoImpl;
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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String val = request.getParameter("searchinfo1");
        CourseDao courseDao = new CourseDaoImpl();
        CourseKindDao courseKind = new CourseKindDaoImpl();
        List<Course> list = courseDao.ShowPrompt(val);
        int i;
        if (list.size() == 0){
            i = 156;
        }else {
            i = list.get(0).getKind_id();
        }
        List<CourseKind> list1 = courseKind.GetKindName(i);
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
