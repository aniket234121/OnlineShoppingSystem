package com.oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oss.DTO.CategoryDTO;
import com.oss.services.CategoryServices;

import jakarta.validation.Valid;

@RestController
public class CategoryController {

	@Autowired
	private CategoryServices categoryServices;
	
	@PostMapping("/category")
	public ResponseEntity<CategoryDTO> addToCategory(@Valid @RequestBody CategoryDTO categoryDTO){
		return new ResponseEntity<CategoryDTO>(this.categoryServices.addToCategory(categoryDTO),HttpStatus.OK);
	}
	
	@PutMapping("/category/{id}")
	public ResponseEntity<CategoryDTO> updateCategoryById(@PathVariable Integer id,@Valid @RequestBody CategoryDTO categoryDTO){
		return new ResponseEntity<CategoryDTO>(this.categoryServices.updateCategoryById(id, categoryDTO),HttpStatus.OK );
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer id){
		return new ResponseEntity<CategoryDTO>(this.categoryServices.getCategoryById(id),HttpStatus.OK);
	}
}
