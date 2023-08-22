package com.oss.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oss.DTO.ProductDTO;
import com.oss.entities.Product;
import com.oss.exceptions.ResourceNotFoundException;
import com.oss.repository.ProductRepository;
import com.oss.services.ProductServices;
import com.oss.utils.Converter;

@Service
public class ProductServiceImpl implements ProductServices {
	@Autowired
	private Converter converter;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) {
		Product product = this.converter.convertToProduct(productDTO);

		return this.converter.convertToProductDTO(this.productRepository.save(product));
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		List<Product> products=this.productRepository.findAll();
		List<ProductDTO> productDTOs=new ArrayList<ProductDTO>();
		for(Product p:products) {
			productDTOs.add(this.converter.convertToProductDTO(p));
		}
		
		return productDTOs;
	}

	@Override
	public ProductDTO getProductById(Integer id) {
		Product product=this.productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","ProductId" , id));
		
		return this.converter.convertToProductDTO(product);
	}

	@Override
	public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
		Product product=this.productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","ProductId" , id));
		Product p=this.converter.convertToProduct(productDTO);
		product.setProduct_detail(p.getProduct_detail());
		product.setProduct_discount(p.getProduct_discount());
		product.setProduct_name(p.getProduct_name());
		product.setProduct_price(p.getProduct_price());
	
		return 	this.converter.convertToProductDTO((this.productRepository.save(product)));
	}

	@Override
	public String deleteProductById(Integer id) {
		Product product=this.productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("product", "ProductId", id));
		this.productRepository.delete(product);
		return "Product Deleted with Id="+id;
	}

}
