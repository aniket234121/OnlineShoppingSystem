package com.oss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oss.DTO.UserDTO;
import com.oss.services.UserServices;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/user")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {

		return new ResponseEntity<UserDTO>(this.userServices.createUser(userDTO), HttpStatus.CREATED);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer id) {

		return new ResponseEntity<UserDTO>(this.userServices.updateUserById(userDTO, id), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> getUserById( @PathVariable Integer id) {
	
		return new ResponseEntity<UserDTO>(	this.userServices.getUserById(id),HttpStatus.OK) ;
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer id){
		
		return new ResponseEntity<String>(this.userServices.deleteUserById(id),HttpStatus.OK);
	}
	@GetMapping("/user")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return new ResponseEntity<List<UserDTO>>(this.userServices.getAllUser(),HttpStatus.OK  );
	}

}
