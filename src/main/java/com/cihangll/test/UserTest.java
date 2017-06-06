package com.cihangll.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cihangll.model.users.User;
import com.cihangll.service.UserService;
import com.cihangll.service.UserServiceImpl;

public class UserTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("UserPersistenceUnitForHibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		UserService uService = new UserServiceImpl(entityManager);
		entityTransaction.begin();
		User user = new User("asdqwe123", "Cihan", "Güllü", "cihangullu54@gmail.com");
		User user2 = new User("asdqwe123", "Yakup", "Yalçın", "ya--kup--@hotmail.com");
		uService.save(user);
		uService.save(user2);
		entityTransaction.commit();
		System.out.println(user);
		System.out.println(user2);
		
		entityTransaction.begin();
		User user3 = uService.findById(1);
		System.out.println("Bulunan kisinin ismi Cihan olmali.= " + user3.getFirst_name());
		entityTransaction.commit();
		

		entityTransaction.begin();
		user.setFirst_name("Ahmet");
		uService.update(user);
		User user4 = uService.findById(1);
		System.out.println("Bulunan kisinin ismi Ahmet olmali.= " + user4.getFirst_name());
		entityTransaction.commit();
		
		entityTransaction.begin();
		List<User> users = uService.findAllUsers();
		for(User u: users) {
			System.out.println(u.getFirst_name());
		}
		System.out.println("2 kisi dönmus olmali.");
		entityTransaction.commit();
		
		entityTransaction.begin();
		uService.deleteById(1);
		List<User> users2 = uService.findAllUsers();
		for(User u: users2) {
			System.out.println(u.getFirst_name());
		}
		System.out.println("1 kisi dönmus olmali.");
		entityTransaction.commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}
}
