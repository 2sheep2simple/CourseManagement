package com.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.course.util.SqlUtil;
import com.google.gson.Gson;

/**
 * Servlet implementation class BaseinfoServlet
 */
@WebServlet("/BaseinfoServlet")
public class BaseinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		SqlUtil service = new SqlUtil();
		
	
		if(method.equals("showall1")){
            
			String sql="select id,type from baseinfo_type";
    		List list = service.getType(sql);
    		response.setCharacterEncoding("utf-8");
    		( response).setContentType("application/json");
    		Gson gson =new Gson();
    		String json=gson.toJson(list);
    		System.out.println(json);
    		PrintWriter  writer  =response.getWriter();
    		writer.print(json);
    		writer.close();
		}

	
		
		if(method.equals("update1")){
			String id = request.getParameter("id");
			String type = request.getParameter("type");
			
			System.out.println(id+type);
			String sql = "update  baseinfo_type  set id = ?,type=? where id = ? ";
			Object []params ={id,type,id};
			int i = service.update(params, sql);
			response.sendRedirect("./baseinfo.html");
			if(i>0){
				System.out.println("update ok");
			}
		}
		if(method.equals("delete1")){
			String id =  request.getParameter("id");
			StringBuilder sqlbuilder = new StringBuilder("delete from baseinfo_type where ");
			sqlbuilder.append(" id ='"+id+"'");
			service.delete(sqlbuilder.toString());
		}
		
		if(method.equals("add1")){
		
		
			String type = request.getParameter("type");
			System.out.println("type");
			String sql = "insert into baseinfo_type(type) values (?)";
			Object []params ={type};
			int i = service.add(params, sql);
			if(i>0){
				System.out.println("add ok");
			}
		}

		if(method.equals("showall2")){
            
			String sql="select id,state from baseinfo_status";
    		List list = service.getStatus(sql);
    		response.setCharacterEncoding("utf-8");
    		response.setContentType("application/json");
    		Gson gson =new Gson();
    		String json=gson.toJson(list);
    		System.out.println(json);
    		PrintWriter  writer  =response.getWriter();
    		writer.print(json);
    		writer.close();
		}

		if(method.equals("delete2")){
			String id =  request.getParameter("id");
			StringBuilder sqlbuilder = new StringBuilder("delete from baseinfo_status where ");
			sqlbuilder.append(" id ='"+id+"'");
			service.delete(sqlbuilder.toString());
		}
		if(method.equals("add2")){
			
			String state = request.getParameter("state");
			System.out.println(state);
			String sql = "insert into baseinfo_status(state) values (?)";
			Object []params ={state};
			int i = service.add(params, sql);
			if(i>0){
				System.out.println("add ok");
			}
		}
		if(method.equals("update2")){
		
			String id = request.getParameter("id");
			String state = request.getParameter("state");
			System.out.println(state);
			String sql = "update  baseinfo_status  set id = ?,state=? where id = ? ";
			Object []params ={id,state,id};
			int i = service.update(params, sql);
			if(i>0){
				System.out.println("update ok");
			}
		}
		   if (method.equals("showall3")) {
//		       
		            String sql = "select * from baseinfo_nation";
		            List list = service.getNation(sql);
		            response.setCharacterEncoding("utf-8");
		            response.setContentType("application/json");
		            Gson gson = new Gson();
		            String json = gson.toJson(list);
		            PrintWriter writer = response.getWriter();
		            writer.print(json);
		            writer.close();
		        }
		        if(method.equals("delete3")){
					String id =  request.getParameter("id");
					StringBuilder sqlbuilder = new StringBuilder("delete from baseinfo_nation where ");
					sqlbuilder.append(" id ='"+id+"'");
					service.delete(sqlbuilder.toString());
				}
				if(method.equals("add3")){
					
					String nation = request.getParameter("name");
					System.out.println(nation);
					String sql = "insert into baseinfo_nation(name) values (?)";
					Object []params ={nation};
					int i = service.add(params, sql);
					if(i>0){
						System.out.println("add ok");
					}
				}
				if(method.equals("update3")){
				
					String id = request.getParameter("id");
					String name = request.getParameter("name");
					System.out.println(name);
					String sql = "update  baseinfo_nation  set id = ?, name=? where id = ? ";
					Object []params ={id,name,id};
					int i = service.update(params, sql);
					if(i>0){
						System.out.println("update ok");
					}
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
