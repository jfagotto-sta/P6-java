package com.OcProject.PayMyBuddy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PayMyBuddyApplication {

	//private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mybuddy");
	
	
	public static void main(String[] args) {
		SpringApplication.run(PayMyBuddyApplication.class, args);
		
		//EntityManager em = emf.createEntityManager();
		
//		User usr1 = new User();
//		usr1.setLastName("paulo");
//		usr1.setFirstName("goergiette");
//		usr1.setMail("test@mail.fr");
//		usr1.setPassword("bidule");
//		usr1.setBalance(5d);
//		
//		em.persist(usr1);
		
		//List<Object> users = em.createQuery("SELECT userId, lastName, firstName, mail, password, balance FROM User where userId = 1").getResultList();
		//System.out.println("test");
		//em.find(User.class, 1);
		
	}

}
