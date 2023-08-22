package com.oss.DTO;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private int order_id;
	@NotNull
	@Size(min=5,max=15,message="order Status must be between 5 to 15 char")
	private String order_status;
	@NotNull
	@Size(min=3,max=15,message="order payment must be between 3 to 15 char")
	private String order_payment;
}
