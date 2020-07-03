package com.unisys.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/table")
public class MultiplicationTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int num = 17;
		int limit = 25;
		
		String input = req.getParameter("num");
		if(input!=null) {
			try {
				num = Integer.parseInt(input);
			}
			catch(Exception ex) {
				// duck the exception
			}
		}
		
		input = req.getParameter("limit");
		if(input!=null) {
			try {
				limit = Integer.parseInt(input);
			}
			catch(Exception ex) {
				// duck the exception
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("table.html");
		rd.include(req, resp); // rd.forward --> closes the response (and it's output stream)
		
		out.println("<p>Mutliplication table for " + num + "</p>");
		out.println("<hr>");
	
		for(var i=1; i<=limit; i++) {
			out.printf("%d X %d = %d <br>", num, i, num*i);
		}
		
		out.close();
		

	}
	
	

}
