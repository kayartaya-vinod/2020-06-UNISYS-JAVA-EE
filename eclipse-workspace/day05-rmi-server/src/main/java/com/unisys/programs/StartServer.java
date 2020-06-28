package com.unisys.programs;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.unisys.service.HelloServiceImpl;

public class StartServer {

	public static void main(String[] args) throws Exception {

		// Step 1: create a service object
		HelloServiceImpl serviceImpl = new HelloServiceImpl();
		
		// Step 2: create a dynamic stub (in the older version, this was done using rmic compiler)
		// The exportObject() method takes an object that implements a remote interface and creates
		// network stub (proxy) which also implements all the remote interfaces implemented by the
		// given object
		var stub = UnicastRemoteObject.exportObject(serviceImpl, 0);
		
		// Step 3: locate a rmiregistry server (by default runs in port 1099)
		Registry registry = LocateRegistry.getRegistry();
		
		// Step 4: bind/rebind the stub in the registry with some "Name"
		registry.rebind("Hello", stub);
		
		System.out.println("Server started successfully!");
		
	}

}
