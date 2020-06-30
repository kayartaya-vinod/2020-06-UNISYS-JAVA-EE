package co.vinod.programs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.vinod.entity.Category;

public class UpdateCategoryData {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("training");
		EntityManager em = emf.createEntityManager();
		

		Category c1 = em.find(Category.class, 9);
		c1.setDescription("Paper, clips, pens, pencils etc");
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		System.out.println("Done!");
		
		em.close();
		emf.close();
	}

}
