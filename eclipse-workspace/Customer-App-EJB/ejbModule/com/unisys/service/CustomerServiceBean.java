package com.unisys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.unisys.entity.Customer;
import com.unisys.repository.CustomerRepository;

@Stateless
public class CustomerServiceBean implements CustomerService {

	
	// Dependency injection only for EJB proxies
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
	public Map<String, String> addNewCustomer(Customer customer) {

		Map<String, String> errors = new HashMap<>();

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
		} else if (repo.getByEmail(email) != null) {
			// 1. check if there is already a customer with the given email
			errors.put("email", "A customer with this email address aready exists in our database.");
		}

		if (phone == null || phone.trim().length() == 0) {
			errors.put("phone", "Phone is mandatory");
		} else if (repo.getByPhone(phone) != null) {
			// 2. check if there is already a customer with the given phone
			errors.put("phone", "A customer with this phone number aready exists in our database.");
		}

		if (errors.size() > 0)
			return errors;

		// 4. add the new customer
		Customer c = repo.addCustomer(customer);
		customer.setId(c.getId());
		return null;
	}

}
