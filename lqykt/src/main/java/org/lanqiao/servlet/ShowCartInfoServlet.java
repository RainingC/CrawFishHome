package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.CourseDao;
import org.lanqiao.dao.CourseDaoImpl;
import org.lanqiao.entity.Cart;
import org.lanqiao.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowCartInfo")
public class ShowCartInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie中用户id
        String id = request.getParameter("user_id");
        int user_id = Integer.parseInt(id);
        Cart cart = new Cart();
        CourseDao courseDao = new CourseDaoImpl();
        cart.setUser_id(user_id);
        //在cart表中检索此用户购物车中的课程id，再到course表中查课程信息
        List<Course> courseList = courseDao.showCourseInfo(cart);
        //输出
        JSONArray jsonArray = JSONArray.fromObject(courseList);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
