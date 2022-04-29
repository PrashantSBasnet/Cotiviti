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

	public Integer id;

	public String userName;

	public String password;

	public String role;

	private Integer bidId;
	
	public UserDto (User entity) {
		this.setId(entity.getId());
		this.setPassword(entity.getPassword());
		this.setRole(entity.getRole());
		this.setUserName(entity.getUserName());
	}



    public List<UserDto> toDto(List<User> entityList) {
	        List<UserDto> dtoList = new ArrayList<>();
	        for (User user : entityList) {
	            dtoList.add(new UserDto(user));
	        }
	        return dtoList;
	    }

}
