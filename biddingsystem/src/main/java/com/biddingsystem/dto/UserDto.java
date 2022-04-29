package com.biddingsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.biddingsystem.entity.User;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	private Integer id;

	private String userName;

	private String password;

	private String role;

	private Integer bidId;
	
	public UserDto (User entity) {
		this.setId(entity.getId());
		this.setPassword(entity.getPassword());
		this.setRole(entity.getRole());
		this.setUserName(entity.getUserName());
		this.setBidId(entity.getBids().getId());
	}



    public List<UserDto> toDto(List<User> entityList) {
	        List<UserDto> dtoList = new ArrayList<>();
	        for (User user : entityList) {
	            dtoList.add(new UserDto(user));
	        }
	        return dtoList;
	    }

}
