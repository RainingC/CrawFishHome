package org.lanqiao.servlet;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.CommentsDao;
import org.lanqiao.dao.CommentsDaoImpl;
import org.lanqiao.entity.Comments;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Date;

@WebServlet("/ShowCommentsServlet")
public class ShowCommentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=1;
        String num1 = request.getParameter("num");
        if(num1!=null&&num1!=""){
            num=Integer.parseInt(num1.trim());
        }
        //1.获得表单数据
        String courseId = request.getParameter("course_id");
        int course_id = Integer.parseInt(courseId);
        // 2.封装对象
        CommentsDao commentsDao = new CommentsDaoImpl();
        int max = commentsDao.select(course_id);
        List<Comments> list = commentsDao.select(course_id,num,7);
        // 3.进行Dao操作
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        jsonArray.add(max);
        // 4.输出操作
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
