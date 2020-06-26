package com.unisys.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

// 1. This interface is going to be used by the clients
// 2. This must be a sub type of java.rmi.Remote
// 3. Every method in this interface must throw java.rmi.RemoteException
// 4. Every parameter or return types must implement java.io.Serializable
public interface HelloService extends Remote {

	public String getGreetingMessage(String name) throws RemoteException;
	
}
