package com.oss.serviceImpl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oss.DTO.UserDTO;
import com.oss.entities.User;
import com.oss.exceptions.ResourceNotFoundException;
import com.oss.repository.UserRepository;
import com.oss.services.UserServices;
import com.oss.utils.Converter;

@Service
public class UserServiceImpl implements UserServices {
	
	@Autowired
	private Converter converter;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		
		User user=this.converter.converToUser(userDTO);
		UserDTO userDTO2= this.converter.converToUserDTO(this.userRepository.save(user));
		return userDTO2;
	}

	@Override
	public UserDTO updateUserById(UserDTO userDTO, Integer id) {
       User user=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","UserId", id));
       User u=this.converter.converToUser(userDTO);
       user.setUser_name(u.getUser_name());
       user.setUser_email(u.getUser_email());
       user.setUser_name(u.getUser_name());
       user.setUser_password(u.getUser_password());
       user.setUser_role(u.getUser_role());
       return this.converter.converToUserDTO(this.userRepository.save(user));
	}

	@Override
	public UserDTO getUserById(Integer id) {
		User user=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","UserId", id));
		UserDTO userDTO2=this.converter.converToUserDTO(user);
		return userDTO2;
	}

	@Override
	public String deleteUserById(Integer id) {
		User user=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","UserId", id));
		this.userRepository.delete(user);
		return "User deleted with id="+id;
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> users=this.userRepository.findAll();
		List<UserDTO> userDTOs=new ArrayList<UserDTO>();
		for(User u:users) {
			userDTOs.add(this.converter.converToUserDTO(u));
		}
		return userDTOs;
	}

}
