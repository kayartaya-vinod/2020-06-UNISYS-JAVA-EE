package com.unisys.service;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface NamesServiceRemote {

	public void addName(String name);
	
	public void deleteName(String name);
	
	public List<String> getNames();
	
	public void empty();
	
}
