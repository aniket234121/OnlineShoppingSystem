package com.oss.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oss.DTO.OrderDTO;
import com.oss.entities.Order;
import com.oss.exceptions.ResourceNotFoundException;
import com.oss.repository.OrderRepository;
import com.oss.services.OrderServices;
import com.oss.utils.Converter;
@Service
public class OrderServiceImpl implements OrderServices {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private Converter converter;

	@Override
	public OrderDTO saveOrder(OrderDTO orderDTO) {
		Order order=this.converter.convertToOrder(orderDTO);
		return this.converter.convertToOrderDTO(this.orderRepository.save(order));
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		List<Order> orders=this.orderRepository.findAll();
		List<OrderDTO> orderDTOs=new ArrayList<OrderDTO>();
		for(Order o:orders) {
			orderDTOs.add(this.converter.convertToOrderDTO(o));
		}
		return orderDTOs;
	}

	@Override
	public OrderDTO getOrderById(Integer id) {
		Order order=this.orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","OrderId", id));
		
		return this.converter.convertToOrderDTO(order);
	}

	@Override
	public OrderDTO updateOrderById(Integer id, OrderDTO orderDTO) {
		Order order=this.orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","OrderId", id));
		Order o=this.converter.convertToOrder(orderDTO);
		order.setOrder_payment(o.getOrder_payment());
		order.setOrder_status(o.getOrder_status());
		return this.converter.convertToOrderDTO(this.orderRepository.save(order));
	}

	@Override
	public String deleteOrderById(Integer id) {
		Order order=this.orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","OrderId", id));
		this.orderRepository.delete(order);
		return "order deleted with id="+id;
	}

}
