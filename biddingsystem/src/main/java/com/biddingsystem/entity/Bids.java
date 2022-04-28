package com.biddingsystem.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_bids")
@Data
public class Bids {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String product_name;

	private String product_description;

	private String bid_status;

	@OneToMany(targetEntity = User.class, mappedBy = "bids")
	List<User> users;

}
