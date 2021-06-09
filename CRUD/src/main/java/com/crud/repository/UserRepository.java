package com.crud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {
//	List<User> findById(String id);
}
