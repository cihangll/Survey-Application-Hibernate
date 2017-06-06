package com.cihangll.dao;

import java.util.List;

import com.cihangll.model.users.User;

public interface UserDAO {

	void save(User user);

	void update(User user);

	User findById(int id);

	void deleteById(int id);

	List<User> findAllUsers();
}
