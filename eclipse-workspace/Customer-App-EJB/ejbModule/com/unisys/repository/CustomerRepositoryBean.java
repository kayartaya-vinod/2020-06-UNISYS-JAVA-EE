package com.unisys.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.unisys.entity.Customer;

@Stateless
public class CustomerRepositoryBean implements CustomerRepository {

	// dependency injection only for injecting EntityManager
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

	@Override
	public Customer getByEmail(String email) {
		try {
			String ql = "from Customer where email=?1";
			TypedQuery<Customer> qry = em.createQuery(ql, Customer.class);
			qry.setParameter(1, email);
			return qry.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Customer getByPhone(String phone) {
		try {
			String ql = "from Customer where phone=?1";
			TypedQuery<Customer> qry = em.createQuery(ql, Customer.class);
			qry.setParameter(1, phone);
			return qry.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
