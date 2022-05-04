package com.biddingsystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.biddingsystem.dto.UserInfo;
import com.biddingsystem.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.biddingsystem.dto.UserDto;
import com.biddingsystem.entity.User;
import com.biddingsystem.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/authenticate")
	public ResponseEntity<UserInfo> authenticate(Authentication authentication) {
		String username = authentication.getName();
		User user = userService.findByUsername(username);
		UserInfo userInfo = UserInfo.builder()
				.userId(user.getId())
				.username(user.getUsername())
				.roles(user.getRoles().stream().map(Role::getRole).collect(Collectors.toSet()))
				.build();
		return new ResponseEntity<>(userInfo, HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers() {

		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	//@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/saveUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws Exception {
		String pwd = userDto.getPassword();
		String encrypt = passwordEncoder.encode(pwd);
		userDto.setPassword(encrypt);
		return new ResponseEntity<UserDto>(userService.save(userDto), HttpStatus.OK);
	}

	@GetMapping("/list/{role}")
	public ResponseEntity<?> findbyStatus(@PathVariable("role") String role) throws Exception {
		List<UserDto> dtoList = userService.findbyRole(role);
		return new ResponseEntity(userService.findbyRole(role), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> findById (@PathVariable("id") Integer id)throws Exception{
		UserDto dto = userService.findById(id);
		return new ResponseEntity<UserDto>(userService.findById(id), HttpStatus.OK);
	}

	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity deleteById (@PathVariable("id") Integer id)throws Exception{
		userService.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}


	@GetMapping("/search-user/{search}")
	public ResponseEntity<List<UserDto>>searchBids(@PathVariable("search") String search) {
		List<UserDto> dtoList = userService.searchUser(search);
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}


	@GetMapping("/total-posted-bids-user/{user_id}")
	public ResponseEntity<Integer> totalPostedBidsByUser (@PathVariable("user_id") Integer user_id) throws Exception{
		Integer count =userService.findtotalPostedBidsByUser(user_id);
		return new ResponseEntity<>(count,HttpStatus.OK);
	}


	@GetMapping("/total-offered-bids-user/{user_id}")
	public ResponseEntity<Integer> totalOfferedBidsByUser (@PathVariable("user_id") Integer user_id) throws Exception{
		Integer count =userService.findtotalOfferedBidsByUser(user_id);
		return new ResponseEntity<>(count,HttpStatus.OK);
	}

}