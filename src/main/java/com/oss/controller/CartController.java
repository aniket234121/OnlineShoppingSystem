package com.oss.controller;

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

import com.oss.DTO.CartDTO;
import com.oss.services.CartServices;

import jakarta.validation.Valid;

@RestController
public class CartController {
	@Autowired
	private CartServices cartServices;
	
	@PostMapping("/cart")
	public ResponseEntity<CartDTO> addToCart(@Valid @RequestBody CartDTO cartDTO){
		return new ResponseEntity<CartDTO>(this.cartServices.addToCart(cartDTO),HttpStatus.OK );
	}
	@GetMapping("/cart/{id}")
	public ResponseEntity<CartDTO> getCartById(@PathVariable Integer id){
		return new ResponseEntity<CartDTO>(this.cartServices.getCartById(id),HttpStatus.OK);
	}
	
	@PutMapping("/cart/{id}")
	public ResponseEntity<CartDTO> updateCartById(@Valid @PathVariable Integer id,@RequestBody CartDTO cartDTO){
		return new ResponseEntity<CartDTO>(this.cartServices.updateCartById(id, cartDTO),HttpStatus.OK );
	}
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<String> deleteCartById(@PathVariable Integer id){
		return new ResponseEntity<String>(this.cartServices.deleteCartById(id),HttpStatus.OK );
	}

}
