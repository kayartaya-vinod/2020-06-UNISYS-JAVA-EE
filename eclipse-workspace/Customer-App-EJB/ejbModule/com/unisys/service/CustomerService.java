package com.unisys.service;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.unisys.entity.Customer;

@Remote
public interface CustomerService {

	public List<Customer> getAllCustomers();
	
	public Customer getCustomer(Integer id);
	
	public Map<String, String> addNewCustomer(Customer customer);
}
