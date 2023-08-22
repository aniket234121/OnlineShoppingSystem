package com.oss.services;

import java.util.List;

import com.oss.DTO.ProductDTO;




public interface ProductServices {

	

ProductDTO	saveProduct(ProductDTO productDTO);
List<ProductDTO> getAllProduct();
ProductDTO getProductById(Integer id);
ProductDTO updateProduct(Integer id,ProductDTO productDTO);
String deleteProductById(Integer id);
}
