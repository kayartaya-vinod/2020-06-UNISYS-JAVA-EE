package com.unisys.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisys.dao.CustomerDao;

@WebServlet("/delete-customer")
public class DeleteCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = -4103854632562898549L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// task 1: read inputs from request (such as parameters, cookies, headers etc)
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		// task 2: invoke a model method (service/dao) and get the model data
		CustomerDao dao = new CustomerDao();
		dao.deleteCustomer(id);
		
		// task 3: store model data in a scope (request, session)

		// task 4: forward to a view (JSP)
		resp.sendRedirect("./view-customers");
		// client side redirection
		// This response asks the browser to visit the server again to the specified url

	}

}
