package com.course.servlet;

import com.course.domain.User;
import com.course.util.SqlUtil;
import com.course.util.Util;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        HttpSession session = request.getSession();
        session.removeAttribute("user");
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        password = Util.getMD5(password);
        String sql = "select * from user where number=" + number;

        Map m = new HashMap();
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        SqlUtil service = new SqlUtil();
        User user = service.login(sql);
        if(user == null)
            m.put("msg", null);
        else if(user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            m.put("msg", user.getName());
            m.put("role", user.getPermission());
        }
        else
            m.put("msg", null);
        String json = gson.toJson(m);
        out.print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
