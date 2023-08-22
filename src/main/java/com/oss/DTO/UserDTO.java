package com.oss.DTO;

import jakarta.validation.constraints.Email;
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
public class UserDTO {

	
	private int user_id;

	@NotNull
	@Size(min=3,max=30,message="username cannot be less than 3 or greater than 30")
	private String user_name;
	@Email(message="email address is not valid")
	private String user_email;
	private String user_role="normal";
	@NotNull
	@Size(min=5,max=15,message="password can be between 5 to 15 char")
	private String user_password;
	@NotNull
	@Size(min=10,max=50,message="address cannot be less than 10 char")
	private String user_address;
}
