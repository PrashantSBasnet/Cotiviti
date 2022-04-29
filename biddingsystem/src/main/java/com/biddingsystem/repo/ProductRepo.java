package com.biddingsystem.repo;


import com.biddingsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "Select * from tbl_product p where p.id =?1", nativeQuery = true)
    Product findProductsById(Integer id);

    @Query(value = "select * from tbl_product", nativeQuery = true)
    List<Product> findAllProducts();
}
