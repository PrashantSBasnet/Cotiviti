package com.biddingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biddingsystem.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query(value = "Select * from tbl_user u where u.id =?1", nativeQuery = true)
	User findById(Integer id);

}