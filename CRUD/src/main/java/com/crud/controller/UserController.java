package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.User;
import com.crud.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllusers() {
		System.out.print("Getting list of all the users :: ");
		return ResponseEntity.ok().body(userService.getAllUsers());
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getProductById(@PathVariable int id) {
		return ResponseEntity.ok().body(userService.getUserById(id));
	}

	@PostMapping("/user")
	public ResponseEntity<User> createProduct(@RequestBody User user) {
		return ResponseEntity.ok().body(this.userService.createUser(user));
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateProduct(@PathVariable int id, @RequestBody User user) {
		user.setId(id);
		return ResponseEntity.ok().body(this.userService.updateUser(user));
	}

	@DeleteMapping("/user/{id}")
	public HttpStatus deleteUser(@PathVariable int id) {
		this.userService.deleteUser(id);
		return HttpStatus.OK;
	}

}
