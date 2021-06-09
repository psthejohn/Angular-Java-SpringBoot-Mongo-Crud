package com.crud.service;

import java.util.List;

import com.crud.model.User;

public interface UserService {
	User createUser(User user);

	User updateUser(User user);

	List<User> getAllUsers();

	User getUserById(int userid);

	void deleteUser(int userid);
}