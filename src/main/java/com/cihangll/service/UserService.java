package com.cihangll.service;

import java.util.List;

import com.cihangll.model.users.User;

public interface UserService {

	void save(User user);

	void update(User user);

	User findById(int id);

	void deleteById(int id);

	List<User> findAllUsers();
}
