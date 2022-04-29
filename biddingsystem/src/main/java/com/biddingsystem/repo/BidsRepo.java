package com.biddingsystem.repo;

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

}
