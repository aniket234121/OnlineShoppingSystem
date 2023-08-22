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
public class CategoryDTO {
	private int category_id;
    @NotNull
    @Size(min=3,max=25,message="category name should be between 3 to 25 char")
	private String category_name;
	@NotNull
	@Size(min=10,max=30,message="category detail should be between 10 to 30")
	private String category_detail;
}
