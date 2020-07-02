package com.unisys.repository;

import java.util.List;

import javax.ejb.Local;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.unisys.entity.Customer;


@Local
public interface CustomerRepository {

	// CRUD OPERATIONS
	
	@Transactional(value = TxType.MANDATORY)
	public Customer addCustomer(Customer customer);
	
	public Customer getCustomerById(Integer id);
	
	// QURIES
	
	public List<Customer> getAllCustomers();
	
	public Customer getByEmail(String email);
	
	public Customer getByPhone(String phone);
}
