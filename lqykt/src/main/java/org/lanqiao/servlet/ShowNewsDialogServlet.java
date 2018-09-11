package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.NewsDao;
import org.lanqiao.dao.NewsDaoImpl;
import org.lanqiao.entity.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowNewsDialogServlet")
public class ShowNewsDialogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("userid"));
        NewsDao newsDao = new NewsDaoImpl();
        List<News> list = newsDao.ShowNewsdialog(uid);
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
