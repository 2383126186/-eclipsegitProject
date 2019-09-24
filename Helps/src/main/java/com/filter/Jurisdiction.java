package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.entity.User;


public class Jurisdiction implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession hs= req.getSession();
		User u = (User) hs.getAttribute("user");
		if(u != null) {
			filter.doFilter(request, response);
		}else {
			res.sendRedirect("jsp/login.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}



}
