package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.PeriodDao;
import org.lanqiao.dao.PeriodDaoImpl;
import org.lanqiao.entity.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/PlareyServlet")
public class PlareyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Id = request.getParameter("id");
        int id = Integer.parseInt(Id);

        PeriodDao periodDao = new PeriodDaoImpl();
        List<Period> list = periodDao.selectId(id);

        JSONArray jsonArray = JSONArray.fromObject(list);

        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
