package com.biddingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biddingsystem.dto.UserDto;
import com.biddingsystem.entity.User;
import com.biddingsystem.repo.UserRepo;
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
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) throws Exception {
		try {
            userDto = userService.save(userDto);
        } catch (NotFoundException e) {
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Saved");
	}
}
