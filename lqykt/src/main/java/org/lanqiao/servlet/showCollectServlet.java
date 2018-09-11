package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.CollectImpl;
import org.lanqiao.entity.Collect;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showCollectServlet")
public class showCollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie中用户id
        String id = request.getParameter("user_id");
        int user_id = Integer.parseInt(id);
        User u = new User();
        u.setUser_id(user_id);
        CollectImpl collect1 = new CollectImpl();
        //在collect表中检索此用户购物车中的课程id，再到course表中查课程信息
        Collect collect = collect1.findMyCourseName(u);
        //输出
        JSONArray jsonArray = JSONArray.fromObject(collect);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();;
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
