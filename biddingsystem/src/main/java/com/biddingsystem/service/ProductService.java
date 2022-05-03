package com.biddingsystem.service;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.dto.ProductDto;
import com.biddingsystem.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto) throws Exception;
    Product findProductIdByproductname(String name) throws  Exception;
}
