package com.biddingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_accepted_bids")
@Getter
@Setter
public class AcceptedBids {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accepted_bid_id;

	private Integer bid_id;

	private Integer buyer_id;

	private Integer seller_id;

}
