package com.oss.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.oss.DTO.CartDTO;
import com.oss.DTO.CategoryDTO;
import com.oss.DTO.OrderDTO;
import com.oss.DTO.ProductDTO;
import com.oss.DTO.UserDTO;
import com.oss.entities.Cart;
import com.oss.entities.Category;
import com.oss.entities.Order;
import com.oss.entities.Product;
import com.oss.entities.User;

@Component
public class Converter {

	// convert user to userDTO
	public UserDTO converToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		if (user != null) {
			BeanUtils.copyProperties(user, userDTO);
		}
		return userDTO;
	}

	// convert user to userDTO
	public User converToUser(UserDTO userDTO) {
		User user = new User();
		if (userDTO != null) {
			BeanUtils.copyProperties(userDTO, user);
		}
		return user;
	}

	// convert product to productDTO
	public ProductDTO convertToProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		if (product != null) {
			BeanUtils.copyProperties(product, productDTO);
		}
		return productDTO;
	}

	// convert productDTO to product
	public Product convertToProduct(ProductDTO productDTO) {
		Product product = new Product();
		if (productDTO != null) {
			BeanUtils.copyProperties(productDTO, product);
		}
		return product;
	}

	// convert cart to cartDTO
	public CartDTO convertToCartDTO(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		if (cart != null) {
			BeanUtils.copyProperties(cart, cartDTO);
		}
		return cartDTO;
	}

	// convert cartDTO to cart
	public Cart convertToCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		if (cartDTO != null) {
			BeanUtils.copyProperties(cartDTO, cart);
		}
		return cart;
	}

	// convert Order to OrderDTO
	public OrderDTO convertToOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		if (order != null) {
			BeanUtils.copyProperties(order, orderDTO);
		}
		return orderDTO;
	}

	// convert OrderDTO to Order
	public Order convertToOrder(OrderDTO orderDTO) {
		Order order = new Order();
		if (orderDTO != null) {
			BeanUtils.copyProperties(orderDTO, order);
		}
		return order;
	}

	// convert Category to CategoryDTO
	public CategoryDTO convertToCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		if (category != null) {
			BeanUtils.copyProperties(category, categoryDTO);
		}
		return categoryDTO;
	}

	// convert CategoryDTO to Category
	public Category convertToCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		if (categoryDTO != null) {
			BeanUtils.copyProperties(categoryDTO, category);
		}
		return category;
	}
}
