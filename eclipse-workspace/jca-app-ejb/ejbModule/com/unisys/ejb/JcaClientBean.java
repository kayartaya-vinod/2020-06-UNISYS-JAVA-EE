package com.unisys.ejb;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.resource.ResourceException;

import com.kvinod.api.HelloWorldConnection;
import com.kvinod.api.HelloWorldConnectionFactory;

@LocalBean
@Singleton
@Startup
public class JcaClientBean {

	@Resource(name = "java:/eis/HelloWorld")
	HelloWorldConnectionFactory connectionFactory;

	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void execute() {
		try(HelloWorldConnection conn = connectionFactory.getConnection();) {
			String msg = conn.helloWorld("Vinod");
			System.out.println("Message from Hello Adapter is : " + msg);
		} catch (ResourceException e) {
			e.printStackTrace();
		}
	}
}
