package com.flexon.springbootDemo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class UserController {
	@Autowired
	private JavaUserRepository userRepo ;
	
	@GetMapping(path="/jpa/printAllUsers")
	public @ResponseBody Iterable<Userspring> printAllUsers() {
		return userRepo.findAll();
	}
	
	@PostMapping(path="/jpa/addUser")
	public ResponseEntity<String> addUser(@RequestBody Userspring user) {
		userRepo.save(user);
		return new ResponseEntity<>("Successfully added user",HttpStatus.OK);
	}
	@PutMapping(path="/jpa/updatePassword/{id}")
	public ResponseEntity<String> updateUser(@RequestBody Userspring user, @PathVariable Long id){
		userRepo.save(user);
		return new ResponseEntity<>("User Updated",HttpStatus.OK);
	}
	
	@DeleteMapping(path="/jpa/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		userRepo.deleteById(id);
		return new ResponseEntity<>("User has been delete", HttpStatus.OK);
	}

}

