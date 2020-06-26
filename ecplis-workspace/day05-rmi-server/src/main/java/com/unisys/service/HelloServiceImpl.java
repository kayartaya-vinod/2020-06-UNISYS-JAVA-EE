package com.unisys.service;

import java.rmi.RemoteException;
import java.util.Date;

// This is the service object that can serve remote clients,
// because it implements a "Remote" interface.
public class HelloServiceImpl implements HelloService {

	@Override
	public String getGreetingMessage(String name) throws RemoteException {
		System.out.println("Got a request for a new greeting message at " + new Date());
		return String.format("Hello, %s!", name);
	}

}
