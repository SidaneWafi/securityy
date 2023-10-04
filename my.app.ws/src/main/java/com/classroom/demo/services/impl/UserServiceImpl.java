package com.classroom.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.classroom.demo.entities.UserEntity;
import com.classroom.demo.repositories.UserRepository;
import com.classroom.demo.services.UserService;
import com.classroom.demo.shared.Utils;
import com.classroom.demo.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
  @Autowired	
  UserRepository userRepository ;
  
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder ;
  
  @Autowired
  Utils utils ;
	@Override
	public UserDto creatUser(UserDto user) {
		
		UserEntity checkUser = userRepository.findByEmail(user.getEmail());
		if(checkUser!=null) throw new RuntimeException("user Already exist ");
		UserEntity userEntity =new UserEntity();
	BeanUtils.copyProperties(user, userEntity);
	userEntity.setEncryptedpassword(bCryptPasswordEncoder.encode(user.getPassword()));
	
	userEntity.setUserId(utils.generateStringId(30));
	UserEntity newUser =userRepository.save(userEntity);
	UserDto userDto=new UserDto();
	BeanUtils.copyProperties(newUser, userDto);
		return userDto ;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email); 
		
		return new User(userEntity.getEmail(), userEntity.getEncryptedpassword(), new ArrayList<>());
	}

	@Override
	public UserDto getUser(String email) {
	
	UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email); 
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userEntity, userDto);
		
		return userDto;
	}

}
