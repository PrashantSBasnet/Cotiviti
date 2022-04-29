package com.biddingsystem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.*;

import javax.persistence.ForeignKey;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bid_id", foreignKey = @ForeignKey(name = "FK_USER_ID_ID"))
	private Bids bids;

	
	
}
