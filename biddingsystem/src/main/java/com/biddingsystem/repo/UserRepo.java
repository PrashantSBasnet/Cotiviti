package com.biddingsystem.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biddingsystem.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value = "Select id, username, role from tbl_user u", nativeQuery = true)
	User findAllUsers();

	@Query(value = "Select * from tbl_user u where u.id =?1", nativeQuery = true)
	User findUserById(Integer id);

	@Query(value = "Select * from tbl_user u where u.role =?1", nativeQuery = true)
	List<User> findByRole (String role);

	@Query(value = "select * from tbl_user u where u.username like '%?1%' ", nativeQuery =true)
	List<User> searchUser(String search);

	//for reports
	@Query(value= "select count(user_id) from tbl_bids where user_id=?1", nativeQuery = true)
	Integer totalBidsUser(Integer id);

	@Query(value= "select count(id) from tbl_bids where bid_status='posted' and user_id = ?1", nativeQuery = true)
	Integer totalPostedBidsByUser(Integer id);

	@Query(value= "select count(id) from tbl_bids where bid_status='offer' and user_id = ?1", nativeQuery = true)
	Integer totalOfferedBidsByUser(Integer id);

	@Query(value="SELECT count(id) FROM TBL_USER ", nativeQuery = true)
	Integer sumAllUsers();

	@Query(value= "select count(user_id) from tbl_bids where bid_status='offer'", nativeQuery = true)
	Integer totalOfferBids();

	@Query(value= "select count(user_id) from tbl_bids where bid_status='posted'", nativeQuery = true)
	Integer totalPostedBids();


	@Query(value = "SELECT a.user_id, c.username,  b.role FROM user_role a INNER JOIN tbl_roles b on a.role_id= b.role_id INNER JOIN tbl_user c on a.user_id = c.id", nativeQuery=true)
	List<Map<String,Object>> displayAllUsers();
}