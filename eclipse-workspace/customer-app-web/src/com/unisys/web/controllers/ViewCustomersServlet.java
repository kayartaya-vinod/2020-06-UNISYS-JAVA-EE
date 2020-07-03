package com.unisys.web.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisys.service.CustomerService;

@WebServlet("/view-customers")
public class ViewCustomersServlet extends HttpServlet {

	private static final long serialVersionUID = 797788813172348042L;

	// The annotation @EJB is meaningless to Tomcat, but WildFly(or any other Application server)
	// understands the significance of this, and attempts to inject an EJB proxy
	@EJB
	CustomerService service;
	
	// @Resource(lookup = "java:/TrainingDS")
	// DataSource dataSource; // connection pool
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			if(service==null) {
				this.service = (CustomerService) this.getServletContext().getAttribute("customerService"); 
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("customers", service.getAllCustomers());
		req.getRequestDispatcher("/WEB-INF/views/show-customers.jsp").forward(req, resp);
	}
}
