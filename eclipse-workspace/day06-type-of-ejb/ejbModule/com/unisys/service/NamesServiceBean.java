package com.unisys.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.unisys.aop.LoggingInterceptor;

@Interceptors({ LoggingInterceptor.class })
@Stateless
public class NamesServiceBean implements NamesServiceRemote {

	// if you initialize this variable during declaration,
	// it's called eager initialization
	private List<String> list;

	public NamesServiceBean() {
		// constructor (for good practice), so that
		// container/skeleton can instantiate this object.

		// Do not use this for member initialization, since if this code
		// depends on some kind of DEPENDENCY injection, then it may fail.

		// better place to initialize is via a custom init function (ref below)
	}

//	@PrePassivate
//	public void beforePassivate() { // names are user defined
//
//	}
//
//	@PostActivate
//	public void afterActivation() { // names are user defined
//
//	}

	// PostConstruct methods are invoked by the frameworks after the constructor
	// execution,
	// and after all the dependencies have been injection
	@PostConstruct
	public void init() {
		this.list = new ArrayList<String>();
	}

	@Override
	public void addName(String name) {
		this.list.add(name);
	}

	@Override
	public void deleteName(String name) {
		if (this.list.contains(name)) {
			this.list.remove(name);
		} else {
			throw new RuntimeException("Name " + name + " not found!");
		}
	}

	@Override
	public List<String> getNames() {
		return this.list;
	}

	@Override
	public void empty() {
		this.list.clear();
	}

}
