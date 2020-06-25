package com.unisys.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisys.dao.CustomerDao;
import com.unisys.model.Customer;

@WebServlet("/view-customers")
public class ViewCustomersServlet extends HttpServlet {

	private static final long serialVersionUID = -2468402782192167513L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// task 1: read inputs from request (such as parameters, cookies, headers etc)
		
		// task 2: invoke a model method (service/dao) and get the model data
		CustomerDao dao = new CustomerDao();
		List<Customer> list = dao.getAllCustomers();
		
		// task 3: store model data in a scope (request, session)
		req.setAttribute("customers", list);
		
		// task 4: forward to a view (JSP)
		req.getRequestDispatcher("/WEB-INF/views/show-customers.jsp").forward(req, resp);
		
	
	}
	
	

}
