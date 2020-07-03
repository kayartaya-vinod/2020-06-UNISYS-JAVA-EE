package com.unisys.web.listener;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.unisys.service.CustomerService;

@WebListener
public class AppStartupListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Properties props = new Properties();
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");
			props.setProperty(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			// create a JNDI context object using the above information
			Context ctx = new InitialContext(props);
			CustomerService customerService = (CustomerService) ctx
					.lookup("ejb:/Customer-App-EJB/CustomerServiceBean!com.unisys.service.CustomerService");

			sce.getServletContext().setAttribute("customerService", customerService);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
