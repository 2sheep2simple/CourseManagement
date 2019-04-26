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

@WebServlet("/lxService")
public class lxServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        lxSqlUtil service = new lxSqlUtil();

        if (method.equals("departmentselect")) {
//            System.out.println("ooo");
            String sql = "select * from department";
            List list = service.select(sql);
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/json");

            Gson gson = new Gson();
            String json = gson.toJson(list);
            PrintWriter writer = response.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("majorselect")) {
//            System.out.println("000");
            String sql = "SELECT major.`id`,major.`num`,major.`name` AS maname,edu_system,department,department.`name` AS dename FROM major JOIN department ON major.department = department.id";
            List list = service.select1(sql);
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/json");

            Gson gson = new Gson();
            String json = gson.toJson(list);
            PrintWriter writer = response.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("classselect")) {
//            System.out.println("000");
            String sql = "SELECT class.`id`,counselor,class.`major`,class.`name` AS clname,class.`number`,class.`time`,user.`name` AS tcname,major.`name` AS majorname FROM class JOIN user ON class.`counselor` = user.`id` JOIN major ON class.`major` = major.`id`";
            List list = service.select2(sql);
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/json");

            Gson gson = new Gson();
            String json = gson.toJson(list);
            PrintWriter writer = response.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("tcselect")) {
//            System.out.println("000");
            String sql = "select * from user where permission = '1'";
            List list = service.select3(sql);
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/json");

            Gson gson = new Gson();
            String json = gson.toJson(list);
            PrintWriter writer = response.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("userselect")) {
//            System.out.println("000");
            String sql = "select * from user";
            List list = service.select3(sql);
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/json");

            Gson gson = new Gson();
            String json = gson.toJson(list);
            PrintWriter writer = response.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("departmentdelete")) {
            String num = request.getParameter("num");
            StringBuilder sqlbuilder = new StringBuilder("delete from department where ");
            sqlbuilder.append(" num ='" + num + "'");
            service.delete(sqlbuilder.toString());
        }
        if (method.equals("majordelete")) {
            String num = request.getParameter("num");
            StringBuilder sqlbuilder = new StringBuilder("delete from major where ");
            sqlbuilder.append(" num ='" + num + "'");
            service.delete(sqlbuilder.toString());
        }
        if (method.equals("classdelete")) {
            String num = request.getParameter("number");
            StringBuilder sqlbuilder = new StringBuilder("delete from class where ");
            sqlbuilder.append(" number ='" + num + "'");
            service.delete(sqlbuilder.toString());
        }
        if (method.equals("userdelete")) {
            String num = request.getParameter("number");
            StringBuilder sqlbuilder = new StringBuilder("delete from user where ");
            sqlbuilder.append(" number ='" + num + "'");
            service.delete(sqlbuilder.toString());
        }

        if (method.equals("departmentadd")) {
            String num = request.getParameter("denum");
            String name = request.getParameter("dename");
//    			String place = request.getParameter("place");
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            System.out.println("servlet接收到的是" + num + name);
            String sql = "insert into department(num,name) values (?,?)";
            Object[] params = {num, name};
            int i = service.add(params, sql);
            if (i > 0) {
                System.out.println("插入成功");
            }
        }
        if (method.equals("majoradd")) {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String num = request.getParameter("manum");
            String name = request.getParameter("maname");
            String edu_system = request.getParameter("masystem");
            String department = request.getParameter("madepartment");
//    			String place = request.getParameter("place");
//            System.out.println("servlet接收到的是" + num + name);
            String sql = "insert into major(num,name,edu_system,department) values (?,?,?,?)";
            Object[] params = {num, name,edu_system,department};
            int i = service.add(params, sql);
            if (i > 0) {
                System.out.println("插入成功");
            }
        }
        if (method.equals("classadd")) {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String num = request.getParameter("clnum");
            String name = request.getParameter("clname");
            String counselor = request.getParameter("counselor");
            String time = request.getParameter("time");
            String major = request.getParameter("major");
//    			String place = request.getParameter("place");
//            System.out.println("servlet接收到的是" + num + name);
            String sql = "insert into class(number,name,counselor,time,major) values (?,?,?,?,?)";
            Object[] params = {num, name,counselor,time,major};
            int i = service.add(params, sql);
            if (i > 0) {
                System.out.println("插入成功");
            }
        }
        if (method.equals("useradd")) {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String number = request.getParameter("unum");
            String name = request.getParameter("uname");
//            String password = request.getParameter("password");
            String permission = request.getParameter("permission");
//    			String place = request.getParameter("place");
//            System.out.println("servlet接收到的是" + number + name);
            String sql = "insert into user(number,name,password,permission) values (?,?,123,?)";
            Object[] params = {number,name,permission};
            int i = service.add(params, sql);
            if (i > 0) {
                System.out.println("插入成功");
            }
        }
        if (method.equals("departmentupdate")) {
            String num = request.getParameter("num");
            String name = request.getParameter("name");
            String id = request.getParameter("id");
//    			String place = request.getParameter("place");
//            System.out.println("servlet接收到的是" + num + name+id);
            String sql = "update  department  set num = ?,name = ? where id = ? ";
            Object[] params = {num,name,id};
            int i = service.update(params, sql);
            if (i > 0) {
                System.out.println("更新成功");
            }
        }
        if (method.equals("majorupdate")) {
            String num = request.getParameter("num");
            String name = request.getParameter("name");
            String edu_system = request.getParameter("system");
            String department = request.getParameter("department");
            String id = request.getParameter("id");
//    			String place = request.getParameter("place");
//            System.out.println("servlet接收到的是" + num + name);
            String sql = "update  major  set num=?,name=?,edu_system=?,department=? where id =? ";
            Object[] params = {num,name,edu_system,department,id};
            int i = service.update(params, sql);
            if (i > 0) {
                System.out.println("更新成功");
            }
        }
        if (method.equals("classupdate")) {
            String num = request.getParameter("clnum");
            String name = request.getParameter("clname");
            String counselor = request.getParameter("counselor");
            String time = request.getParameter("time");
            String major = request.getParameter("major");
            String id = request.getParameter("id");
//    			String place = request.getParameter("place");
//            System.out.println("servlet接收到的是" + num + name);
            String sql = "update  department  set number=?,name=?,counselor=?,time=?,major=? where id=?";
            Object[] params = {num,name,counselor,time,major,id};
            int i = service.update(params, sql);
            if (i > 0) {
                System.out.println("更新成功");
            }
        }
        if (method.equals("userupdate")) {
            String num = request.getParameter("number");
            String name = request.getParameter("name");
//            String password = request.getParameter("password");
            String permission = request.getParameter("permission");
            String id = request.getParameter("id");
//    			String place = request.getParameter("place");
//            System.out.println("servlet接收到的是" + num + name+permission+id);
            String sql = "update  user  set number=?,name=?,permission=? where id=?";
            Object[] params = {num,name,permission,id};
            int i = service.update(params, sql);
            if (i > 0) {
                System.out.println("更新成功");
            }
        }
        if(method.equals("userpasswordreset")){
            String id = request.getParameter("id");
//            System.out.println("servlet接收到的是" +id);
            String sql = "update user set password=md5(123) where id =?";
            Object[] params = {id};
            int i = service.update(params, sql);
            if (i > 0) {
                System.out.println("更新成功");
            }
        }
    }
}
