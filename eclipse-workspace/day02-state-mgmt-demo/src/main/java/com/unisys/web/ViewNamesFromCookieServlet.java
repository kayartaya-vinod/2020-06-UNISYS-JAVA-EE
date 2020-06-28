package com.unisys.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewNamesFromCookie")
public class ViewNamesFromCookieServlet extends HttpServlet {

	private static final long serialVersionUID = -6038356813017056342L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		req.getRequestDispatcher("index.html").include(req, resp);

		out.println("<h3>Here are the names you stored:</h3>");
		out.println("<ul>");
		for (var c : req.getCookies()) {
			if (c.getName().startsWith("name")) {
				out.printf("<li>%s</li>", c.getValue());
			}
		}
		out.println("</ul>");
		out.close();
		
	}

}
