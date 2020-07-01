package com.unisys.web.controllers;

import java.io.IOException;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
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
				// no dependency injection done
				// manually get a proxy for service reference
				Properties props = new Properties();
				props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
				props.setProperty(Context.PROVIDER_URL, "http-remoting://localhost:8080");
				// create a JNDI context object using the above information
				Context ctx = new InitialContext(props);
				this.service = (CustomerService) ctx.lookup("ejb:/Customer-App-EJB/CustomerServiceBean!com.unisys.service.CustomerService");
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
