package com.course.servlet;

import com.course.util.lxSqlUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Service")
public class MainServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse resposne) throws ServletException, IOException {

        String method = request.getParameter("method");
        lxSqlUtil service = new lxSqlUtil();

        if (method.equals("showall")) {
//            System.out.println("ooo");
            String sql = "select * from baseinfo_nation";
            List list = service.select(sql);
            resposne.setCharacterEncoding("utf-8");
            resposne.setContentType("application/json");
            Gson gson = new Gson();
            String json = gson.toJson(list);
            PrintWriter writer = resposne.getWriter();
            writer.print(json);
            writer.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
