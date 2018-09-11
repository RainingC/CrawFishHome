package org.lanqiao.servlet;

import org.lanqiao.dao.NewsDao;
import org.lanqiao.dao.NewsDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        int courseid = Integer.parseInt(request.getParameter("courseid"));
        String newsinfo = request.getParameter("newsinfo");
        NewsDao newsDao = new NewsDaoImpl();
        int ret = newsDao.AddNews(userid,courseid,newsinfo);
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
