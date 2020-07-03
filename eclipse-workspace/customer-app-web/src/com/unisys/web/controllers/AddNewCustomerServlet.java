package com.unisys.web.controllers;

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisys.entity.Customer;
import com.unisys.service.CustomerService;

@WebServlet("/add-new-customer")
public class AddNewCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1323723280989815441L;

	@EJB
	CustomerService service;

	private static final String PAGE_TITLE = "Add a new customer data";

	// @Resource(lookup = "java:/TrainingDS")
	// DataSource dataSource; // connection pool

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			if (service == null) {
				this.service = (CustomerService) this.getServletContext().getAttribute("customerService");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("pageTitle", PAGE_TITLE);
		req.getRequestDispatcher("/WEB-INF/views/customer-form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer c = new Customer();
		c.setName(req.getParameter("name"));
		c.setCity(req.getParameter("city"));
		c.setEmail(req.getParameter("email"));
		c.setPhone(req.getParameter("phone"));

		Map<String, String> errors = service.addNewCustomer(c);

		if (errors != null) {
			// has errors; forward to the form
			req.setAttribute("errors", errors);
			req.setAttribute("pageTitle", PAGE_TITLE);
			req.getRequestDispatcher("/WEB-INF/views/customer-form.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("./view-customers");
		}
	}

}
