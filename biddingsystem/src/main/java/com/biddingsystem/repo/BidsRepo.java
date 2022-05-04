package com.biddingsystem.repo;

import com.biddingsystem.entity.Bids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BidsRepo extends JpaRepository<Bids, Integer> {

    @Query(value = "Select * from tbl_bids b where b.id =?1", nativeQuery = true)
    Bids findBidsById(Integer id);


    @Query(value="SELECT * FROM TBL_BIDS where bid_status= ?1", nativeQuery = true)
    List<Bids> findByStatus(String status);

    //gives all bid ignoring specific user(logged in)
    @Query(value = "select * from tbl_bids b where  b.bid_status = 'offer' and b.user_id <> ?1", nativeQuery = true)
    List<Bids> findAvailabeBids (Integer id);

    @Query(value = "SELECT * FROM tbl_bids a INNER JOIN tbl_product b ON a.product_product_id = b.product_id where b.product_name like '%?1%'", nativeQuery =true)
    List<Bids> searchBids(String search);


    //reports

    @Query(value="SELECT count(id) FROM TBL_BIDS where bid_status ='offer'", nativeQuery = true)
    Integer sumAllOfferBid();

    @Query(value="SELECT count(id) FROM TBL_BIDS where bid_status ='posted'", nativeQuery = true)
    Integer sumAllPostedBid();


    @Query(value="SELECT count(b.id) FROM TBL_BIDS b where b.bid_status ='offer' and b.product_product_id = ?1", nativeQuery = true)
    Integer totalBidsPerProduct(Integer id);

    @Query(value = "select * from tbl_bids where bid_status='offer'", nativeQuery = true)
    List<Bids> findAllBids();


    @Query(value= "SELECT a.id as bidid, a.is_settled, a.bid_status, a.bidding_rate, b.product_name, a.user_id\n" +
            "FROM tbl_bids a\n" +
            "INNER JOIN tbl_product b\n" +
            "ON a.product_product_id= b.product_id\n" +
            "where a.bid_status='offer' and a.user_id <> ?1 \n" +
            "order by bidding_rate desc;", nativeQuery = true)
    List<Map<String,Object>> offersInMyPosts(Integer userId);



}
