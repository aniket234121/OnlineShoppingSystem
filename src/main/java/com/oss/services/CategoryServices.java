package com.oss.services;

import com.oss.DTO.CategoryDTO;

public interface CategoryServices {

	CategoryDTO addToCategory(CategoryDTO categoryDTO);
	CategoryDTO updateCategoryById(Integer id,CategoryDTO categoryDTO);
	CategoryDTO getCategoryById(Integer id);
	
}
