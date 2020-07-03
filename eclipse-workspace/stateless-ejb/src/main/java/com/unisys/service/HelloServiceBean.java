package com.unisys.service;

import java.util.Date;

import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.Pool;

@Stateless
@Pool("slsb-strict-max-pool")
public class HelloServiceBean implements HelloService {
	
	public HelloServiceBean() {
	}

	// pure function, since stateless should not contain data members
	@Override
	public String getGreetingMessage(String name) {
		System.out.println("Got a request from a client at " + new Date());
		return String.format("Hello, %s! EJB 3.x is super cool.", name);
	}

}
