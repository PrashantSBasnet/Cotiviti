package com.biddingsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="tbl_roles")
public class Role {
    @Id
    @GeneratedValue
    private Integer role_Id;

    private String role;
}
