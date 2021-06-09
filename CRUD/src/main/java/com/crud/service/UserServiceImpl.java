package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.model.User;
import com.crud.repository.UserRepository;
import com.crud.exception.ResourceNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> userDB = this.userRepository.findById(user.getId());

		if (userDB.isPresent()) {
			System.out.println("User is present"+user);
			User userUpdate = userDB.get();
			userUpdate.setId(user.getId());
			userUpdate.setName(user.getName());
			userUpdate.setEmail(user.getEmail());
			userUpdate.setPassword(user.getPassword());
			userRepository.save(userUpdate);
			return userUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + user.getId());
		}
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> userDB = this.userRepository.findById(userId);
		if (userDB.isPresent()) {
			return userDB.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User> userDB = this.userRepository.findById(userId);
		if (userDB.isPresent()) {
			this.userRepository.delete(userDB.get());
		} else {

			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}
}
