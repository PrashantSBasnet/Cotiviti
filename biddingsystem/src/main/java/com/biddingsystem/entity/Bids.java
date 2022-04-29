package com.biddingsystem.entity;

import java.util.List;


import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "tbl_bids")
@Getter
@Setter
public class Bids {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	private String product_name;
//
//	private String product_description;

	private String bid_status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	User users;

	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	Product product;
	
}
