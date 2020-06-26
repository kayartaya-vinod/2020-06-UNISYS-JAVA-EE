package com.unisys.service;

import javax.ejb.Remote;

@Remote
public interface HelloService {
	public String getGreetingMessage(String name);
}
