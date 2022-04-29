package com.biddingsystem.repo;

import java.util.List;

import com.biddingsystem.entity.Bids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biddingsystem.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value = "Select * from tbl_user u where u.id =?1", nativeQuery = true)
	User findUserById(Integer id);

	@Query(value = "Select * from tbl_user u where u.role =?1", nativeQuery = true)
	List<User> findByRole (String role);

	@Query(value = "select * from tbl_user u where u.name like %?1% ", nativeQuery =true)
	List<User> searchUser(String search);

}