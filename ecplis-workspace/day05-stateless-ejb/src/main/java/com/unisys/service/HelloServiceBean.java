package com.unisys.service;

import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class HelloServiceBean implements HelloService {

	@Override
	public String getGreetingMessage(String name) {
		System.out.println("Got a request from a client at " + new Date());
		return String.format("Hello, %s! EJB 3.x is super cool.", name);
	}

}
