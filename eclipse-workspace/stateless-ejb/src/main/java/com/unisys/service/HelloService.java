package com.unisys.service;

import javax.ejb.Remote;

@Remote
//@Local // Cannot mark an interface both Local and Remote
public interface HelloService {
	public String getGreetingMessage(String name);
}
