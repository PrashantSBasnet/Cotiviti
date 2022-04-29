package com.biddingsystem.repo;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.entity.Bids;
import com.biddingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidsRepo extends JpaRepository<Bids, Integer> {

    @Query(value = "Select * from tbl_bids b where b.id =?1", nativeQuery = true)
    Bids findBidsById(Integer id);

    @Query(value = "select * from tbl_bids", nativeQuery = true)
    List<Bids> findAllBids();

    @Query(value="SELECT * FROM TBL_BIDS where bid_status= ?1", nativeQuery = true)
    List<Bids> findByStatus(String status);

    //gives all posted/purchased bid ignoring specific user(logged in)
    @Query(value = "select * from tbl_bids b where  b.bid_status = 'true' and b.user_id <> ?1", nativeQuery = true)
    List<Bids> findAvailabeBids (Integer id);

    @Query(value = "select * from tbl_bids where product_name like %?1% ", nativeQuery =true)
    List<Bids> searchBids(String search);


}
