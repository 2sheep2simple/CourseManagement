//package com.course.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.course.domain.User;
//import com.course.util.SqlUtil;
//import com.course.util.Util;
//import com.google.gson.Gson;
//
///**
// * Servlet implementation class LoginServlet
// */
//@WebServlet("/LoginServlet")
//public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public LoginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("222");
//		request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//		String method = request.getParameter("method");
//		SqlUtil service = new SqlUtil();
//		HttpSession  session  =request.getSession();
//		System.out.println("method:"+method);
//		if(method.equals("login")){
//			System.out.println("111");
//			String number=request.getParameter("number");
//			String password =request.getParameter("password");
//			System.out.println(number+password);
//			StringBuilder sqlbuilder=new StringBuilder("select password,permission from user where ");
//			sqlbuilder.append("number="+number);
//			User user=service.login(sqlbuilder.toString());
////			System.out.println(user.getPassword()+"aaaa"+user.getPermission());
//			int i = Integer.parseInt(user.getPermission());
//			System.out.println(i);
//
//			if(user.getPassword().equals(Util.getMD5(password))&&i==1) {
//				session.setAttribute("key",number);
//				Map params = new HashMap();
//            	params.put("msg", 1);
//            	Gson gson =new Gson();
//        		String json= gson.toJson(params);
//        		PrintWriter  writer  =response.getWriter();
//        		writer.print(json);
//        		writer.close();
//			}
//			else if(user.getPassword().equals(Util.getMD5(password))&&i==0) {
//				session.setAttribute("key",number);
//				Map params = new HashMap();
//            	params.put("msg", 2);
//            	Gson gson =new Gson();
//        		String json= gson.toJson(params);
//        		PrintWriter  writer  =response.getWriter();
//        		writer.print(json);
//        		writer.close();
//			}
//			else {
//				Map params = new HashMap();
//				params.put("msg", 3);
//				Gson gson =new Gson();
//				String json= gson.toJson(params);
//				PrintWriter  writer  =response.getWriter();
//				writer.print(json);
//				writer.close();
//			}
//
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
