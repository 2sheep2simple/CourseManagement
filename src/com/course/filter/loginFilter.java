//package com.course.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet Filter implementation class loginFilter
// */
//@WebFilter(filterName = "loginFilter",urlPatterns = "/*.html")
//public class loginFilter implements Filter {
//
//    /**
//     * Default constructor.
//     */
//    public loginFilter() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		// place your code here
//
//        HttpSession session=((HttpServletRequest) request).getSession();//获取session
//
//        String path =((HttpServletRequest) request).getRequestURI();//获取url
//
//        Integer uid= (Integer)session.getAttribute("key");
//
//        if(path.indexOf("/index.html")>-1){//若url包含index.html,则不过滤
//        	System.out.println("------------------------------------");
//        	chain.doFilter(request, response);//放行
//
//			((HttpServletResponse) response).sendRedirect("dashboard_teacher.html");
//            return;
//        }
//		if(path.contains(".css") || path.contains(".js") || path.contains(".png")|| path.contains(".jpg")){
//			//如果发现是css或者js文件，直接放行
//			chain.doFilter(request, response);
//		}
//
//        if(uid!=null){//若已经登陆
//        	chain.doFilter(request, response);//放行
//        }else{
//            ((HttpServletResponse) response).sendRedirect("index.html");
//        }
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		System.out.println("----过滤器初始化----");
//	}
//
//}
