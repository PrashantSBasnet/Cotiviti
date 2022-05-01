package com.biddingsystem.entity;


import javax.persistence.*;


import lombok.*;


import java.util.List;
import java.util.Set;

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

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Bids> bidList;

	@OneToMany
	private List<Product> products;

}
