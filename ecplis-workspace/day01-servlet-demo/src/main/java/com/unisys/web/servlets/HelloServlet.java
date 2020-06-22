package com.unisys.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println(">>> HelloServlet.init() called..");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println(">>> HelloServlet.service() called..");
		
		// MIME 
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Hello, world!</h1>");
		out.println("<hr>");
		out.println("<p>Powered by Servlet 4.x</p>");
		
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println(">>> HelloServlet.destroy() called..");
	}


	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		return "HelloServlet, responds to the user with a greeting.";
	}


}
