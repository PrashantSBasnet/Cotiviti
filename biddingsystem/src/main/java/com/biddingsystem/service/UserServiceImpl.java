package com.biddingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.biddingsystem.dto.UserDto;
import com.biddingsystem.entity.User;
import com.biddingsystem.repo.UserRepo;

import lombok.*;

@Data
@Service
@Builder
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDto save(UserDto dto) {
		User user;
		if (dto.getId() != null && dto.getId() != 0) {
			user = userRepo.findById(dto.getId());
		} else {
			user = new User();
		}
		user.setId(dto.getId());
		user.setUserName(dto.getUserName());
		user.setRole(dto.getRole());
		user.setPassword(dto.getPassword());

		userRepo.save(user); // repo takes entity
		return dto;
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public List<UserDto> findbyRole(String role) {
		List<User> userList = userRepo.findByRole(role);
		return UserDto.builder().build().toDto(userList);
	}

}
