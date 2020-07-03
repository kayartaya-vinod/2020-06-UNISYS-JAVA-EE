package com.unisys.entity;

import com.unisys.annotations.Csv;
import com.unisys.annotations.Include;

@Csv
public class Person {

	@Include
	public String name;
	@Include
	public String email;
	public String phone;

	public Person() {
	}

	public Person(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
