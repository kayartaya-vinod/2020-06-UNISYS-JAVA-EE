package com.unisys.programs;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.unisys.service.HelloService;

public class RmiClient {

	public static void main(String[] args) throws Exception {

		Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
		
		System.out.println("these are the registered stub names:");
		var list = registry.list();
		for(var l: list) {
			System.out.println(l);
		}
		
		HelloService service = (HelloService) registry.lookup("Hello");
		System.out.println("service refers to an object of type: " + service.getClass());
		var msg = service.getGreetingMessage("Vinod");
		System.out.println(msg);


	}
}
