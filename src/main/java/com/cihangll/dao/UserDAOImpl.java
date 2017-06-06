package com.cihangll.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cihangll.model.users.User;

public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;

	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(User user) {
		entityManager.persist(user);
	}

	@Override
	public void update(User user) {
		entityManager.merge(user);
	}

	@Override
	public User findById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void deleteById(int id) {
		User user = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.id LIKE :id").setParameter("id", id)
				.getSingleResult();
		entityManager.remove(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> users = entityManager.createQuery("SELECT u FROM User u ORDER BY u.first_name ASC").getResultList();
		return users;
	}

}
