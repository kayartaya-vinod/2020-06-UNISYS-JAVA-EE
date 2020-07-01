package com.unisys.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unisys.entity.Customer;

@Stateless
public class CustomerRepositoryBean implements CustomerRepository {
	
	@PersistenceContext(unitName = "Training-PU")
	private EntityManager em;

	@Override
	public Customer addCustomer(Customer customer) { // customer.id --> null
		em.persist(customer);
		return customer; // customer.id --> newly generated id
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return em.find(Customer.class, id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return em.createQuery("from Customer", Customer.class).getResultList();
	}

}
