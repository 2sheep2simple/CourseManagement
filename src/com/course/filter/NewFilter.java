package com.course.filter;

import com.course.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "NewFilter",urlPatterns = {"*.html", "/*Servlet"})
public class NewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String url =((HttpServletRequest) servletRequest).getRequestURI();
        System.out.println(url);
        if(url.equals("/") || url.equals("/login") || url.equals("/index.html"))
            filterChain.doFilter(servletRequest, servletResponse);
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("user");
        if(user != null && !url.equals("/dashboard_teacher.html"))
            filterChain.doFilter(servletRequest, servletResponse);
        System.out.println(user.getPermission());
        if(url.equals("/dashboard_teacher.html") && user.getPermission().equals("1")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
