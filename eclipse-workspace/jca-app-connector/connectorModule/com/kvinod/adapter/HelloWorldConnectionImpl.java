package com.kvinod.adapter;

import com.kvinod.api.HelloWorldConnection;

public class HelloWorldConnectionImpl implements HelloWorldConnection {
	private HelloWorldManagedConnection mc;

	private HelloWorldManagedConnectionFactory mcf;

	public HelloWorldConnectionImpl(HelloWorldManagedConnection mc, HelloWorldManagedConnectionFactory mcf) {
		this.mc = mc;
		this.mcf = mcf;
	}

	public String helloWorld() {
		return helloWorld(((HelloWorldResourceAdapter) mcf.getResourceAdapter()).getName());
	}

	public String helloWorld(String name) {
		return mc.helloWorld(name);
	}

	public void close() {
		mc.closeHandle(this);
	}
}