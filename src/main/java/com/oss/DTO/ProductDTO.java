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
public class ProductDTO {
	private int product_id;

	@NotNull
	@Size(min=3,max=30,message="product name should be between 3 to 30 char")
	private String product_name;

	@NotNull
	private int product_discount;

	@NotNull
	private int product_price;

	@NotNull
	@Size(min=10,max=50,message="product detail should be more than 10 less than 50 char")
	private String product_detail;
}
