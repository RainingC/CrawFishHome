package org.lanqiao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/user1")
public class ShowUserServlet extends HttpServlet {
//    public  ShowUserServlet() {
//        System.out.println("构造方法");
//
//    }

    public void init() {
        System.out.println("初始化方法");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("服务");
    }
}
