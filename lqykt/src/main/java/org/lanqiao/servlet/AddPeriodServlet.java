package org.lanqiao.servlet;

import org.lanqiao.dao.PeriodDao;
import org.lanqiao.dao.PeriodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddPeriodServlet")
public class AddPeriodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("courseid"));
        int pid = Integer.parseInt(request.getParameter("periodid"));
        String pname = request.getParameter("periodname");
        String address = request.getParameter("address");
        PeriodDao periodDao = new PeriodDaoImpl();
        int ret = periodDao.AddPeriod(cid,pid,pname,address);
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
