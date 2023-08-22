package com.oss.DTO;


import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
	private int cart_id;
	@NotNull
    @Range(min=100,max=100000,message="must be between 100 and 100000")
	private int cart_bill;
	@NotNull
	@Range(min = 1, max = 10, message = "must be between 1 and 10")
	private int cart_quantity;
}
