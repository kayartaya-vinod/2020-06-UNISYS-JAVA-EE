package com.unisys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewNamesFromSession")
public class ViewNamesFromSessionServlet extends HttpServlet {

	private static final long serialVersionUID = 6121003005427518221L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		req.getRequestDispatcher("session-demo.html").include(req, resp);
		
		
		HttpSession session = req.getSession();
		if(session.isNew()) {
			out.println("<h3>You don't have any names!!</h3>");
		}
		else {
			List<String> names = (List<String>) session.getAttribute("names");
			if(names !=null && names.size()>0) {
				out.println("<h3>Here are the names you stored:</h3>");
				out.println("<ul>");
				
				for(var name: names) {
					out.printf("<li>%s</li>", name);
				}
				
				out.println("</ul>");
			}
		}
		
		out.close();
	
	}
	// 7A17611000ED9029CBEB7B22CE76FAFA
	// JSESSIONID	7B7DCD3A9ED06EEBC731A64400370263
	

}
