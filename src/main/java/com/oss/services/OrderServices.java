package com.oss.services;

import java.util.List;

import com.oss.DTO.OrderDTO;

public interface OrderServices {

	OrderDTO saveOrder(OrderDTO orderDTO);
	List<OrderDTO> getAllOrders();
	OrderDTO getOrderById(Integer id);
	OrderDTO updateOrderById(Integer id,OrderDTO orderDTO);
	String deleteOrderById(Integer id);
	
}
