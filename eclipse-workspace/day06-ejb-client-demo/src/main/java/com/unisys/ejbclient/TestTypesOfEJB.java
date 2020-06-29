package com.unisys.ejbclient;

import com.unisys.service.NamesServiceRemote;
import com.unisys.utils.EjbUtil;

public class TestTypesOfEJB {

	public static void main(String[] args) throws Exception {

		String jndiName = "ejb:/day06-type-of-ejb/NamesServiceBean!com.unisys.service.NamesServiceRemote";

		NamesServiceRemote c = (NamesServiceRemote) EjbUtil.getEjbProxy(jndiName);
		c.addName("Ramesh");
		
		final NamesServiceRemote c1 = (NamesServiceRemote) EjbUtil.getEjbProxy(jndiName);
		final NamesServiceRemote c2 = (NamesServiceRemote) EjbUtil.getEjbProxy(jndiName);
		
		var t1 = new Thread(() -> {
			c1.addName("Vinod");
			c1.addName("Shyam");
		});
		t1.start();

		var t2 = new Thread(() -> {
			c2.addName("John");
			c2.empty();
			c2.addName("Jane");
		});
		t2.start();

		t1.join();
		t2.join();
		
		c.addName("Harish");
		
		System.out.println("names in c = " + c.getNames());
		System.out.println("names in c1 = " + c1.getNames());
		System.out.println("names in c2 = " + c2.getNames());
		
	}

}
