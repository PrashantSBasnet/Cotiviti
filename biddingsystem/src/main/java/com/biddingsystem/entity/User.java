package com.biddingsystem.entity;


import javax.persistence.*;


import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String userName;

	@Column(name = "role")
	private String role;

	@Column(name = "password")
	private String password;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Bids> bidList;


	
	
}
