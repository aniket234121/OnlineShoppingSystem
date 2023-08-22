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

import com.oss.DTO.ProductDTO;
import com.oss.services.ProductServices;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	@Autowired
	private ProductServices productServices;

	@PostMapping("/product")
	public ResponseEntity<ProductDTO> saveProduct(@Valid @RequestBody ProductDTO productDTO) {

		return new ResponseEntity<ProductDTO>(this.productServices.saveProduct(productDTO), HttpStatus.CREATED);
	}

	@GetMapping("/product")
	public ResponseEntity<List<ProductDTO>> getAllProduct() {
		return new ResponseEntity<List<ProductDTO>>(this.productServices.getAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
		return new ResponseEntity<ProductDTO>(this.productServices.getProductById(id),HttpStatus.OK  );
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<ProductDTO> updateProductById(@Valid @PathVariable Integer id,@RequestBody ProductDTO productDTO){
		
		return new ResponseEntity<ProductDTO>( this.productServices.updateProduct(id, productDTO),HttpStatus.OK );
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Integer id){
		
		return new ResponseEntity<String>(this.productServices.deleteProductById(id),HttpStatus.OK);
	}
	
}
