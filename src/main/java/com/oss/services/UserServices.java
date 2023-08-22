package com.oss.services;

import java.util.List;

import com.oss.DTO.UserDTO;

public interface UserServices {
	
UserDTO createUser(UserDTO userDTO);
UserDTO updateUserById(UserDTO userDTO,Integer id);
UserDTO getUserById(Integer id);
String deleteUserById(Integer id);
List<UserDTO> getAllUser();
}
