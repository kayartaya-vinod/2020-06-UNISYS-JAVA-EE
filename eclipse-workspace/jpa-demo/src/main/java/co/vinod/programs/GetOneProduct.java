package co.vinod.programs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.vinod.entity.Product;

public class GetOneProduct {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("training");
		EntityManager em = emf.createEntityManager();
		
		Product pr = em.find(Product.class, 1);
		// System.out.println(pr);
		System.out.println("Name = " + pr.getProductName());
		System.out.println("Category name = " + pr.getCategory().getCategoryName());
		

		System.out.println();
		System.out.println("Related/similar products: ");
		var relatedProducts = pr.getCategory().getProducts();
		for(var p: relatedProducts) {
			System.out.println(p);
		}
		
		em.close();
		emf.close();
	}

}
