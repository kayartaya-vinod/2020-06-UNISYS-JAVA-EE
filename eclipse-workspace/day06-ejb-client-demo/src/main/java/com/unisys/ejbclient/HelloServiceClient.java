package com.unisys.ejbclient;

import com.unisys.service.HelloService;
import com.unisys.utils.EjbUtil;

public class HelloServiceClient {

	public static void main(String[] args) throws Exception {

		String namespace = "ejb:";
		String appName = ""; // EAR project name
		String moduleName = "/day05-stateless-ejb"; // EJB project name
		String distinctName = "";
		String beanName = "/HelloServiceBean";
		String remoteInterface = "com.unisys.service.HelloService";
		
		String jndiName = namespace + appName + moduleName + distinctName + beanName + "!" + remoteInterface;
		
		// returns the stub, which is an instance of your remote interface (HelloService)
		HelloService service = (HelloService) EjbUtil.getEjbProxy(jndiName);
		System.out.println("Got a HelloService instance of type: " + service.getClass().getName());
		
		System.out.println("Server message is: " + service.getGreetingMessage("Vinod"));
		service = null;
	}

}
