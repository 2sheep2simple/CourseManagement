package com.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.course.domain.Student;
import com.course.util.SwjSqlUtil;
import com.google.gson.Gson;

@WebServlet("/SwjServlet")
public class SwjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	SwjSqlUtil  util  = new SwjSqlUtil ();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");//获取ajax方法url里的method
	    System.out.println(method);//打印method
	    
		if(method.equals("init")){
	    	init(request,response);
	    }
		if(method.equals("myinfo")){
			myinfo(request,response);
		}
		
	}
    
	private void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取session
		String session = "161003";  //学生登陆，sesion取到的是用户表里的number
		 //定义sql
         String sql = "select name,hour,credit,type,week,time,classroom,teacher from course";
         List list = util.select(sql);
        response.setCharacterEncoding("utf-8");
 		response.setContentType("application/json");
 		Gson gson =new Gson();
 		String json=gson.toJson(list);
 		PrintWriter  writer  =response.getWriter();
 		writer.print(json);
 		writer.close();
	}
	
	private void myinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("come myinfo");
		//获取session
		String session = "1011";  //学生登陆，sesion取到的是用户表里的number
		String sql = "select name,sex,birthday,native_place,nation,class as clas from student";
		Student stu = util.select1(sql);
		System.out.println(stu.getName());
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		Gson gson =new Gson();
		String json=gson.toJson(stu);
		PrintWriter  writer  =response.getWriter();
		writer.print(json);
		writer.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
