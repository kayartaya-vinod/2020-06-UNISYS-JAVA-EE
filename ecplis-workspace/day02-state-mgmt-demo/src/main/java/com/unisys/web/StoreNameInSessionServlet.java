package com.unisys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/storeNameInSession")
public class StoreNameInSessionServlet extends HttpServlet {

	private static final long serialVersionUID = 3812311572548330184L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		if (name != null && name.trim().length() > 0) {
			
			HttpSession session = req.getSession();
			System.out.println("session is of type: " + session.getClass());
			
			// req.getSession() --> checks for a cookie in the request called "JSESSIONID"
			// if found, then there is already a session associated with the user; retrieve the same
			// if not found, then create a new session object (using the API of the implementer); return the same
			// Also, the session id is added to the response as a cookie called "JSESSIONID"
			
			List<String> list = (List<String>) session.getAttribute("names");
			
			// returns null, if the session does not contain any such key/value pair
			if(list == null) {
				// this happens only for the first visit by a client
				list = new ArrayList<>();
				session.setAttribute("names", list);
			}
			
			list.add(name);
			
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		req.getRequestDispatcher("session-demo.html").include(req, resp);

		out.println("Name \"" + name + "\" stored as cookie!");

	}

}
