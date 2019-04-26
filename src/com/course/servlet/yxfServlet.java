package com.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.course.domain.Elective;
import com.course.domain.Student;
import com.course.domain.Yxcourse;
import com.course.util.SqlUtil;
import com.google.gson.Gson;
@WebServlet("/yxfService")
public class yxfServlet extends HttpServlet {
	      //HttpSession session;
	Elective elective =new Elective();
	//Student student=new Student();
	 protected void service(HttpServletRequest request, HttpServletResponse resposne) throws ServletException, IOException {

	        String method = request.getParameter("method");
	        SqlUtil service = new SqlUtil();
	       // System.out.println(method);
	        	
	        if (method.equals("courseshowall")) {
	            String sql = "SELECT course.`status` AS coursestatus,course.`id` AS courseid,`hour`,credit,full_number,current_number,baseinfo_status.`state` AS `status`,course.name ,course.number,WEEK,`time`,classroom,baseinfo_type.type,user.`name` AS teacher FROM course JOIN baseinfo_status ON course.`status`=baseinfo_status.id JOIN `user` ON course.teacher=`user`.id JOIN baseinfo_type ON course.type=baseinfo_type.id";
	            
	            String sql1 = "SELECT course.`status` AS coursestatus,course.`id` AS courseid,`hour`,credit,full_number,current_number,baseinfo_status.`state` AS `status`,course.name ,course.number,WEEK,`time`,classroom,baseinfo_type.type,user.`name` AS teacher FROM course JOIN baseinfo_status ON course.`status`=baseinfo_status.id JOIN `user` ON course.teacher=`user`.id JOIN baseinfo_type ON course.type=baseinfo_type.id WHERE course.`status`=1";
	            Gson gson = new Gson();
	            Elective elective = new Elective();
	            if(elective.getCoursestatus()==2) {
	            	List list1 = service.select(sql1);
	            	String json1 = gson.toJson(list1);
	            	resposne.setCharacterEncoding("utf-8");
		            resposne.setContentType("application/json");
		           
		            PrintWriter writer = resposne.getWriter();
		            writer.print(json1);
		            writer.close();
	            }
	            else {
	            	 List list = service.select(sql);
	 	             String json = gson.toJson(list);
	 	            resposne.setCharacterEncoding("utf-8");
		            resposne.setContentType("application/json");
		           
		            PrintWriter writer = resposne.getWriter();
		            writer.print(json);
		            writer.close();
	            }
	            
	        }
	        
	        if (method.equals("yxcourse")) {
	        	//System.out.println("============");
	            String sql = "SELECT elective.`score`,elective.`student_id`,elective.`course_id`,elective.`id`,course.`number`,course.`name` ,course.`hour`,course.`credit`,course.`week`,course.`time`,course.`classroom`,user.`name` AS teacher FROM elective JOIN course ON elective.`course_id`=course.`id` JOIN `user` ON course.`teacher`=user.`id`";
	            List list = service.select3(sql);
	            resposne.setCharacterEncoding("utf-8");
	            resposne.setContentType("application/json");
	            Gson gson = new Gson();
	            String json = gson.toJson(list);
	            PrintWriter writer = resposne.getWriter();
	            writer.print(json);
	            writer.close();
	        }
	    
	        if (method.equals("selectit")) {
	        	String session = "1001003";
	        	String id = request.getParameter("courseid");
	        	System.out.println("courseid="+id);
	        	String sql ="SELECT id FROM student WHERE student_num = "+session;
	        	Student  student  = service.select1(sql);
	        	System.out.println("studentid="+student.getId());
//	        	String sql3 ="SELECT flag FROM elective WHERE student_id = ? AND course_id = ?";
	        	Object [] params2 = {student.getId(),id};
//	        	Yxcourse yxcourse = service.select4(sql3);
//	        	int flag = yxcourse.getFlag();
//	        	System.out.println(flag);
				String sql1="INSERT INTO elective (student_id,course_id,score) VALUES(?,?,0)";
				Object [] params = {student.getId(),id};
				String sql2="UPDATE course SET current_number=current_number+1 WHERE id=?";
				Object [] params1 = {id};
				int num1 = service.add(params, sql1);
				int num2 = service.update(params1, sql2);
				if(num1>0) {
					System.out.println("success1");
				}
				if(num2>0) {
					System.out.println("success2");
				}
	        	
	        	resposne.setCharacterEncoding("utf-8");
	        	resposne.setContentType("application/json");
	        	
	        	
	        }
	        
	        if (method.equals("changescore")) {
	            String sql = "SELECT elective.`id` AS id, score, student.`name` AS studentname, student_num ,course.`name` AS coursename, course.`number` AS course_num FROM elective JOIN student ON elective.`student_id` = student.`id` JOIN course ON elective.`course_id` = course.`id` ";
	            List list = service.select2(sql);
	            
	            resposne.setCharacterEncoding("utf-8");
	            resposne.setContentType("application/json");
	            Gson gson = new Gson();
	            String json = gson.toJson(list);
	            PrintWriter writer = resposne.getWriter();
	            writer.print(json);
	            writer.close();
	        }
	        if(method.equals("update")){
    		
    			String score = request.getParameter("score");
    			String id = request.getParameter("id");
    			System.out.println("servlet接收到的是"+score+id);
    			String sql = "update  elective  set score = ? where id = ? ";
    			Object []params ={score,id};
    			int i = service.update(params, sql);
    			if(i>0){
    				System.out.println("更新成功");
    			}
    		}
	        if(method.equals("delete")){
    			String id =  request.getParameter("id");
    			String number =  request.getParameter("number");
    			StringBuilder sqlbuilder = new StringBuilder("delete from elective where ");
    			sqlbuilder.append(" id ='"+id+"'");
    			service.delete(sqlbuilder.toString());
    			String sql1="UPDATE course SET current_number=current_number-1 WHERE number=?";
	        	Object [] params1 = {number};
	        	int num1 = service.update(params1, sql1);
	        	if(num1>0) {
	        		System.out.println("success1");
	        	}
    		}
	        
	        if(method.equals("update1")){
	        	resposne.setCharacterEncoding("utf-8");
		        resposne.setContentType("application/json");
	        	String id = request.getParameter("courseid");
    			String status = request.getParameter("status");
    			String hour = request.getParameter("hour");
    			String credit = request.getParameter("credit");
    			String week = request.getParameter("week");
    			String time = request.getParameter("time");
    			String current_number = request.getParameter("current_number");
    			String full_number = request.getParameter("full_number");
    			System.out.println("servlet接收到的是"+status+hour+credit+week+time+current_number+full_number+id);
    			String sql = "UPDATE course SET `status`=?, `hour`=?, credit=?, `week`=?, `time`=?, current_number=?, full_number=?  WHERE id=? ";
    			Object []params ={status,hour,credit,week,time,current_number,full_number,id};
    			int i = service.update(params, sql);
    			if(i>0){
    				System.out.println("更新成功");
    			}
    		}
	    }
	 
	 

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    }
}
