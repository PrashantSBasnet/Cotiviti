package com.biddingsystem.service;

import java.util.List;

import com.biddingsystem.dto.UserDto;
import com.biddingsystem.entity.User;


public interface UserService {
	
	
	public List<User> findAll();

	UserDto save(UserDto userDto) throws Exception;
	
	
}