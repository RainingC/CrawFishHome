package org.lanqiao.servlet;

import org.lanqiao.dao.CommentsDao;
import org.lanqiao.dao.CommentsDaoImpl;
import org.lanqiao.entity.Comments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/InsertCommentsServlet")
public class InsertCommentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得数据
        String course_id = request.getParameter("course_id");
        String content = request.getParameter("content");
        String user_name = request.getParameter("user_name");
        int couese_id = Integer.parseInt(course_id);
        //封装对象
        Comments comments = new Comments();
        comments.setContent(content);
        comments.setCourse_id(couese_id);
        comments.setUser_name(user_name);
        CommentsDao commentsDao = new CommentsDaoImpl();
        int ret = commentsDao.insert(comments);
        //输出对象
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
