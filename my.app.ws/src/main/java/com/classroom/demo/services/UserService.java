package com.classroom.demo.services;



import org.springframework.security.core.userdetails.UserDetailsService;

import com.classroom.demo.shared.dto.UserDto;


public interface UserService extends UserDetailsService{

	UserDto creatUser(UserDto userDto);
	UserDto getUser(String email);

}
