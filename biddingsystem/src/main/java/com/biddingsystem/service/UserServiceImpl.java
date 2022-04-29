package com.biddingsystem.service;

import java.util.List;
import java.util.Optional;

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
			user = userRepo.findUserById(dto.getId()); //from repo, created by programmer
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
		return (List<User>) userRepo.findAll();  //becasue directly fetching from repo
	}

	@Override
	public UserDto findById(Integer id) {
		Optional<User> userOptional= userRepo.findById(id);  //method available in spring boot JpaRepository
		if(userOptional.isPresent()){
			User entity = userOptional.get();
			return UserDto.builder()
					.id(entity.getId())
					.userName(entity.getUserName())
					.password(entity.getPassword()).build();
		}
		return  null;
	}

	@Override
	public List<UserDto> findbyRole(String role) {
		List<User> userList = userRepo.findByRole(role);
		return UserDto.builder().build().toDto(userList);
	}

	@Override
	public void deleteById(Integer id) {
		userRepo.deleteById(id);
	}

}
