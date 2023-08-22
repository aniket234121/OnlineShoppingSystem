package com.oss.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oss.DTO.CartDTO;
import com.oss.entities.Cart;
import com.oss.exceptions.ResourceNotFoundException;
import com.oss.repository.CartRepository;
import com.oss.services.CartServices;
import com.oss.utils.Converter;

@Service
public class CartServiceImpl implements CartServices {
	@Autowired
	private Converter converter;
	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartDTO addToCart(CartDTO cartDTO) {
	Cart cart=this.converter.convertToCart(cartDTO);
	
		return this.converter.convertToCartDTO(this.cartRepository.save(cart));
	}

	@Override
	public CartDTO getCartById(Integer id) {
		Cart cart=this.cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart", "cartId", id));
		
		return this.converter.convertToCartDTO(cart);
	}

	@Override
	public CartDTO updateCartById(Integer id,CartDTO cartDTO) {
		Cart cart=this.cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart", "cartId", id));
		Cart c=this.converter.convertToCart(cartDTO);
		cart.setCart_bill(c.getCart_bill());
		cart.setCart_quantity(c.getCart_quantity());
		
		return this.converter.convertToCartDTO(this.cartRepository.save(cart));
	}

	@Override
	public String deleteCartById(Integer id) {
		Cart cart=this.cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart", "cartId", id));
		this.cartRepository.delete(cart);
		return "Cart deleted with cart id="+id;
	}

}
