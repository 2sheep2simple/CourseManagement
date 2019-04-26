package com.course.servlet;

import com.course.util.SqlUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/syfServlet")
public class syfServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse resposne) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        SqlUtil service = new SqlUtil();

        if (method.equals("getStudent")) {
            String sql = "select student.id as id, student_num, student.name as name, sex, birthday, native_place, baseinfo_nation.name as nation, class.`name` as clas from student\n" +
                    "left join baseinfo_nation on student.nation=baseinfo_nation.id\n" +
                    "left join class on student.class=class.id\n" +
                    "order by student_num;";
            List list = service.getStudent(sql);
            resposne.setCharacterEncoding("utf-8");
            resposne.setContentType("application/json");
            Gson gson = new Gson();
            String json = gson.toJson(list);
            System.out.println(json);
            PrintWriter writer = resposne.getWriter();
            writer.print(json);
            writer.close();
        }


        if (method.equals("getCourse")) {
            String sql = "select course.id as id, course.number, course.name as name, hour, credit, baseinfo_type.type as type, week, time, classroom, user.name as teacher, full_number, current_number, baseinfo_status.state as status from course\n" +
                    "left join baseinfo_status on course.status = baseinfo_status.id\n" +
                    "left join user on course.teacher = user.id\n" +
                    "left join baseinfo_type on course.type = baseinfo_type.id\n" +
                    "order by number;";
            List list = service.getCourse(sql);
            resposne.setCharacterEncoding("utf-8");
            resposne.setContentType("application/json");
            Gson gson = new Gson();
            String json = gson.toJson(list);
            System.out.println(json);
            PrintWriter writer = resposne.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("getNation")) {
//            System.out.println("ooo");
            String sql = "select * from baseinfo_nation";
            List list = service.getNation(sql);
            resposne.setCharacterEncoding("utf-8");
            resposne.setContentType("application/json");
            Gson gson = new Gson();
            String json = gson.toJson(list);
            System.out.println(json);
            PrintWriter writer = resposne.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("getType")) {
//            System.out.println("ooo");
            String sql = "select * from baseinfo_type";
            List list = service.getType(sql);
            resposne.setCharacterEncoding("utf-8");
            resposne.setContentType("application/json");
            Gson gson = new Gson();
            String json = gson.toJson(list);
            System.out.println(json);
            PrintWriter writer = resposne.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("getStatus")) {
//            System.out.println("ooo");
            String sql = "select * from baseinfo_status";
            List list = service.getStatus(sql);
            resposne.setCharacterEncoding("utf-8");
            resposne.setContentType("application/json");
            Gson gson = new Gson();
            String json = gson.toJson(list);
            System.out.println(json);
            PrintWriter writer = resposne.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("getClas")) {
//            System.out.println("ooo");
            String sql = "select * from class";
            List list = service.getStatus(sql);
            resposne.setCharacterEncoding("utf-8");
            resposne.setContentType("application/json");
            Gson gson = new Gson();
            String json = gson.toJson(list);
            System.out.println(json);
            PrintWriter writer = resposne.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("getTeacher")) {
//            System.out.println("ooo");
            String sql = "select * from user where permission = 1";
            List list = service.getTeacher(sql);
            resposne.setCharacterEncoding("utf-8");
            resposne.setContentType("application/json");
            Gson gson = new Gson();
            String json = gson.toJson(list);
            System.out.println(json);
            PrintWriter writer = resposne.getWriter();
            writer.print(json);
            writer.close();
        }

        if (method.equals("addStudent")) {
//            System.out.println("ooo");
            String student_num = request.getParameter("student_num");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String birthday = request.getParameter("birthday");
            String native_place = request.getParameter("native_place");
            int nation = Integer.parseInt(request.getParameter("nation"));
            int clas = Integer.parseInt(request.getParameter("clas"));
            String sql = "INSERT INTO student(`student_num`, `name`, `sex`, `birthday`, `native_place`, `nation`, `class`) VALUES (?, ?, ?, ?, ?, ?, ?);";
            Object[] params = {student_num, name, sex, birthday, native_place, nation, clas};
            service.addStudent(sql, params);
        }

        if (method.equals("addCourse")) {
            String number = request.getParameter("number");
            String name = request.getParameter("name");
            String hour = request.getParameter("hour");
            String credit = request.getParameter("credit");
            String type = request.getParameter("type");
            String week = request.getParameter("week");
            String time = request.getParameter("time");
            String classroom = request.getParameter("classroom");
            String teacher = request.getParameter("teacher");
            String full_number = request.getParameter("full_number");
            String current_number = request.getParameter("current_number");
            String status = request.getParameter("status");
            String sql = "INSERT INTO `course`.`course`(`number`, `name`, `hour`, `credit`, `type`, `week`, `time`, `classroom`, `teacher`, `full_number`, `current_number`, `status`)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Object[] params = {number, name, hour, credit, type, week, time, classroom, teacher, full_number, current_number, status};
            System.out.println(params);
            service.addStudent(sql, params);
        }

        if(method.equals("editStudent")) {
            String id = request.getParameter("id");
            String student_num = request.getParameter("student_num");
            String name = request.getParameter("name");
            System.out.println(name);
            String sex = request.getParameter("sex");
            System.out.println(sex);
            String birthday = request.getParameter("birthday");
            String native_place = request.getParameter("native_place");
            int nation = Integer.parseInt(request.getParameter("nation"));
            int clas = Integer.parseInt(request.getParameter("clas"));
            String sql = "UPDATE student SET `student_num` = ?, `name` = ?, `sex` = ?, `birthday` = ?, `native_place` = ?, `nation` = ?, `class` = ? WHERE `id` = ?;";
            Object[] params = {student_num, name, sex, birthday, native_place, nation, clas, id};
            service.editStudent(sql, params);
        }

        if(method.equals("editCourse")) {
            String number = request.getParameter("number");
            String name = request.getParameter("name");
            String hour = request.getParameter("hour");
            String credit = request.getParameter("credit");
            String type = request.getParameter("type");
            String week = request.getParameter("week");
            String time = request.getParameter("time");
            String classroom = request.getParameter("classroom");
            String teacher = request.getParameter("teacher");
            String full_number = request.getParameter("full_number");
            String current_number = request.getParameter("current_number");
            String status = request.getParameter("status");
            int id = Integer.parseInt(request.getParameter("id"));
            String sql = "UPDATE `course`.`course` SET `number` = ?, `name` = ?, `hour` = ?, `credit` = ?, `type` = ?, `week` = ?, `time` = ?, `classroom` = ?, `teacher` = ?, `full_number` = ?, `current_number` = ?, `status` = ? WHERE `id` = ?;";
            Object[] params = {number, name, hour, credit, type, week, time, classroom, teacher, full_number, current_number, status, id};
            service.addStudent(sql, params);
        }

        if(method.equals("delStudent")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String sql = "delete from student where student_num=?";
            Object[] params = {id};
            service.delStudent(sql, params);
        }

        if(method.equals("delCourse")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String sql = "delete from course where id=?";
            Object[] params = {id};
            service.delStudent(sql, params);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
