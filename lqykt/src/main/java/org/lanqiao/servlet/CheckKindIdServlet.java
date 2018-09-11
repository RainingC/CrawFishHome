package org.lanqiao.servlet;

import org.lanqiao.dao.CourseKindDao;
import org.lanqiao.dao.CourseKindDaoImpl;
import org.lanqiao.entity.CourseKind;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CheckKindIdServlet")
public class CheckKindIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kname = request.getParameter("kindname");
        CourseKindDao courseKind = new CourseKindDaoImpl();
        List<CourseKind> list = courseKind.CheckCourseId(kname);
        PrintWriter out=response.getWriter();
        out.print(list);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
