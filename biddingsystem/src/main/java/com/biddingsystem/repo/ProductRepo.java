package com.biddingsystem.repo;


import com.biddingsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "Select * from tbl_product p where p.product_id =?1", nativeQuery = true)
    Product findProductsById(Integer id);

    @Query(value = "select * from tbl_product", nativeQuery = true)
    List<Product> findAllProducts();

    //reports

    @Query(value = "select max(bidding_rate) from tbl_bids \n" +
            "where product_product_id =\n" +
            "(\n" +
            "select product_product_id from tbl_bids \n" +
            "where bid_status ='posted' and user_id= ?1\n" +
            ")", nativeQuery = true)
    Integer maxBidOfferedForUserProduct(Integer userid);



    @Query(value = "Select * from tbl_product p where p.product_id =\n" +
            "(select product_id from tbl_product where product_name = 'Motorcycle')", nativeQuery = true)
    Product findProductIdByProductName(String productname);


    @Query (value= "SELECT a.product_product_id, b.product_description, b.product_name, a.bid_status,  a.user_id FROM tbl_bids a INNER JOIN tbl_product b ON a.product_product_id= b.product_id and a.bid_status = 'posted'", nativeQuery = true)
    List<Map<String,Object>> showAllPostedBids();
}
