package com.oss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oss.DTO.OrderDTO;
import com.oss.services.OrderServices;

import jakarta.validation.Valid;

@RestController
public class OrderController {
	@Autowired
	private OrderServices orderServices;
	
	@PostMapping("/order")
	public ResponseEntity<OrderDTO> saveOrder(@Valid @RequestBody OrderDTO orderDTO) {
		return new ResponseEntity<OrderDTO>(this.orderServices.saveOrder(orderDTO),HttpStatus.OK);
	}
	
	@GetMapping("/order")
	public ResponseEntity<List<OrderDTO>> getAllOrders(){
		return new ResponseEntity<List<OrderDTO>>(this.orderServices.getAllOrders(),HttpStatus.OK );
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable Integer id){
		return new ResponseEntity<OrderDTO>( this.orderServices.getOrderById(id),HttpStatus.OK );
	}
	@PutMapping("/order/{id}")
	public ResponseEntity<OrderDTO> updateOrderById( @PathVariable Integer id,@Valid @RequestBody OrderDTO orderDTO){
		return new ResponseEntity<OrderDTO>(this.orderServices.updateOrderById(id, orderDTO),HttpStatus.OK );
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable Integer id){
		return new ResponseEntity<String>(this.orderServices.deleteOrderById(id),HttpStatus.OK );
	}

}
