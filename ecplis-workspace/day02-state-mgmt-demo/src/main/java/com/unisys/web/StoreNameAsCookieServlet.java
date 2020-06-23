package com.unisys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/store", "/storeName", "/storeNameAsCookie" })
public class StoreNameAsCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 378040345915598977L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		if(name!=null && name.trim().length()>0) {
			Cookie c1 = new Cookie("name" + new Date().getTime(), name);
			c1.setMaxAge(60*60*24*365*20);
			// c1.setSecure(true); // SSL required
			resp.addCookie(c1);
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		req.getRequestDispatcher("index.html").include(req, resp);
		
		out.println("Name \"" + name + "\" stored as cookie!");
		
		
	}

}
