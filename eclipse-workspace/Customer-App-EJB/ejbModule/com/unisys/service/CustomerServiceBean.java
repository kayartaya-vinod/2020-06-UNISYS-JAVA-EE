package com.unisys.service;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.unisys.entity.Customer;
import com.unisys.repository.CustomerRepository;

@Stateless
public class CustomerServiceBean implements CustomerService {

	@EJB
	CustomerRepository repo;

	@Override
	public List<Customer> getAllCustomers() {
		return repo.getAllCustomers();
	}

	@Override
	public Customer getCustomer(Integer id) {
		return repo.getCustomerById(id);
	}

	@Override
	public void addNewCustomer(Customer customer, Map<String, String> errors) {
		// business logic value addition:
		// 0. check for all mandatory fields
		String name = customer.getName();
		String email = customer.getEmail();
		String phone = customer.getPhone();

		if (name == null || name.trim().length() == 0) {
			errors.put("name", "Name is mandatory");
		}
		if (email == null || email.trim().length() == 0) {
			errors.put("email", "Email is mandatory");
		}
		if (phone == null || phone.trim().length() == 0) {
			errors.put("phone", "Phone is mandatory");
		}
		// 1. check if there is already a customer with the given email
		if (repo.getByEmail(email) != null) {
			errors.put("email", "This is email is already registered");
		}
		// 2. check if there is already a customer with the given phone
		if (repo.getByPhone(phone) != null) {
			errors.put("phone", "This is phone is already registered");
		}
		
		if(errors.size()>0) return;
		
		// 4. add the new customer
		Customer c = repo.addCustomer(customer);
		customer.setId(c.getId());
	}

}
