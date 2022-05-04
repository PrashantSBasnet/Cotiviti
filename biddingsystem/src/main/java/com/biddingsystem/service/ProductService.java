package com.biddingsystem.service;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.dto.ProductDto;
import com.biddingsystem.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ProductDto save(ProductDto productDto) throws Exception;
    Product findProductIdByproductname(String name) throws  Exception;

    List<Map<String,Object>> showAllPostedBids();
}
