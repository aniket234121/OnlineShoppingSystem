package com.oss.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oss.DTO.CategoryDTO;
import com.oss.entities.Category;
import com.oss.exceptions.ResourceNotFoundException;
import com.oss.repository.CategoryRepository;
import com.oss.services.CategoryServices;
import com.oss.utils.Converter;

@Service
public class CategoryServiceImpl implements CategoryServices{

	@Autowired
	private Converter converter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public CategoryDTO addToCategory(CategoryDTO categoryDTO) {
	   Category category=this.converter.convertToCategory(categoryDTO);
	   
		return this.converter.convertToCategoryDTO(this.categoryRepository.save(category));
	}

	@Override
	public CategoryDTO updateCategoryById(Integer id, CategoryDTO categoryDTO) {
		Category category=this.converter.convertToCategory(categoryDTO);
		Category c=this.categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", id));
		c.setCategory_detail(category.getCategory_detail());
		c.setCategory_name(category.getCategory_name());
		
		return this.converter.convertToCategoryDTO(this.categoryRepository.save(c));
	}

	@Override
	public CategoryDTO getCategoryById(Integer id) {
        Category category=this.categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", id));
		return this.converter.convertToCategoryDTO(category);
	}

}
