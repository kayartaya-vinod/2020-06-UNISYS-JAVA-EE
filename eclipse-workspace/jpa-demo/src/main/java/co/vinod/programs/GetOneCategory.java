package co.vinod.programs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.vinod.entity.Category;

public class GetOneCategory {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("training");
		EntityManager em = emf.createEntityManager();
		
		Integer categoryId = 1;
		Category c1 = em.find(Category.class, categoryId);
		
		em.close();
		emf.close();
		
		System.out.println(c1);
	}

}
