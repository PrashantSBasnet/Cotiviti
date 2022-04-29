package com.biddingsystem.entity;

import java.util.List;


import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_bids")
@Getter
@Setter
public class Bids {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String product_name;

	private String product_description;

	private String bid_status;

	@OneToMany(targetEntity = User.class, mappedBy = "bids")
	List<User> users;

	public Bids(Integer id, String product_name, String product_description, String bid_status, List<User> users) {
		this.id = id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.bid_status = bid_status;
		this.users = users;
	}

	
}
