package co.vinod.programs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.vinod.entity.Supplier;

public class GetSupplierAndSuppliedProducts {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("training");
		EntityManager em = emf.createEntityManager();
		
		var sup = em.find(Supplier.class, 1);
		System.out.println("Company name = " + sup.getCompanyName());
		System.out.println("City         = " + sup.getContactDetails().getCity());
		
		System.out.println("Products supplied by this supplier: ");
		for(var p: sup.getProducts()) {
			System.out.println(p);
		}
		
		em.close();
		emf.close();
	}

}
