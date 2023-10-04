package com.classroom.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.demo.requests.UserRequest;
import com.classroom.demo.responses.UserResponse;
import com.classroom.demo.services.UserService;
import com.classroom.demo.shared.dto.UserDto;


@RestController
@RequestMapping("/users")
public class useController {
	@Autowired
	UserService userService ;
	
	@GetMapping
	public String getUser() {
		return " get user was called  ";
	}
	
    @PostMapping
	public UserResponse creatUser(@RequestBody UserRequest userRequest) {
		UserDto userDto= new UserDto();  
		BeanUtils.copyProperties(userRequest, userDto);
		UserDto creaUser =userService.creatUser(userDto);
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(creaUser, userResponse);
		return userResponse ;
	}

    @PutMapping
	public String updateUser() {
		return " update user was called  ";
	}

    @DeleteMapping
	public String deleteUser() {
		return " delete user was called  ";
	}

}
