package com.kvinod.api;

import java.io.Closeable;

public interface HelloWorldConnection extends Closeable {
	
	public String helloWorld();

	public String helloWorld(String name);

	public void close();
}