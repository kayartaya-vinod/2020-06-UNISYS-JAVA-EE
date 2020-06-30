package co.vinod.programs;

import java.io.FileInputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import co.vinod.entity.Category;

public class AddNewCategory {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("training");
		EntityManager em = emf.createEntityManager();
		
		Category c1 = new Category();
		c1.setCategoryName("Stationaries");
		c1.setDescription("Pencils, pens, books etc.");

		try(
			FileInputStream file = new FileInputStream("stationaries.jpg");
		) {
			int size = file.available();
			byte[] picture = new byte[size];
			file.read(picture);
			c1.setPicture(picture);
		}
		catch(Exception ex) {}
		
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(c1);
			System.out.println("Data in c1 saved to db as new category record!");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		em.close();
		emf.close();
	}

}
