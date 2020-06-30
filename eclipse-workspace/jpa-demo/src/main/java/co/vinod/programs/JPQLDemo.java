package co.vinod.programs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import co.vinod.entity.Product;

public class JPQLDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("training");
		EntityManager em = emf.createEntityManager();
		
		// select * from products where units_in_stock=0
		// select p from Product p where p.unitsInStock = 0
		// from Product where unitsInStock=0
		
		// String jpql = "select p from Product p where p.unitsInStock = 0";
		
		String jpql = "select p from Product p where p.unitsInStock > ?1 and p.unitPrice between ?2 and ?3 order by p.unitPrice desc";
		TypedQuery<Product> qry = em.createQuery(jpql, Product.class);
		
		qry.setParameter(1, 0);
		qry.setParameter(2, 50.0);
		qry.setParameter(3, 500.0);
		
		var list = qry.getResultList();
		
		// System.out.println("Following products are out of stock:");
		for(var p: list) {
			System.out.println(p.getProductName() + " --> $" + p.getUnitPrice());
		}
		em.close();
		emf.close();
	}

}
