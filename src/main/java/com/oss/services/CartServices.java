package com.oss.services;



import com.oss.DTO.CartDTO;

public interface CartServices {
	CartDTO addToCart(CartDTO cartDTO);
	CartDTO getCartById(Integer id);
	CartDTO updateCartById(Integer id,CartDTO cartDTO);
	String deleteCartById(Integer id);

}
