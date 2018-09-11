package org.lanqiao.servlet;

import org.lanqiao.dao.CollectDao;
import org.lanqiao.dao.CollectImpl;
import org.lanqiao.entity.Collect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/insertCollect")
public class insertCollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String uid = request.getParameter("user_id");
       String cid = request.getParameter("course_id");
        int user_id = Integer.parseInt(uid);
        int course_id = Integer.parseInt(cid);
        Collect collect = new Collect();
        collect.setUser_id(user_id);
        collect.setCourse_id(course_id);
        CollectDao collectDao = new CollectImpl();
        int ret = collectDao.insertCollectInfo(collect);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);

        }
}
