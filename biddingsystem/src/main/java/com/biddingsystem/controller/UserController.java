package com.biddingsystem.controller;

import java.util.List;

import com.biddingsystem.dto.BidsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers() {

		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/saveUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws Exception {
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

}