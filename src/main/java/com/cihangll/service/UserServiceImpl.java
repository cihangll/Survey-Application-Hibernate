package com.cihangll.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.cihangll.dao.UserDAO;
import com.cihangll.dao.UserDAOImpl;
import com.cihangll.model.users.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	public UserServiceImpl(EntityManager entityManager) {
		userDao = new UserDAOImpl(entityManager);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		userDao.deleteById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

}
