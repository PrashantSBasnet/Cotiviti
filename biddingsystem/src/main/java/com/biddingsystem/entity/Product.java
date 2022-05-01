package com.biddingsystem.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tbl_product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    private String product_name;

    private String product_description;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    User user;

}
