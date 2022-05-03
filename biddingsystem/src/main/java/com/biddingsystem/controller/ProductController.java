package com.biddingsystem.controller;

import com.biddingsystem.dto.ProductDto;
import com.biddingsystem.entity.Product;
import com.biddingsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) throws Exception {
        return new ResponseEntity<ProductDto>(productService.save(productDto), HttpStatus.OK);
    }

    @GetMapping("/find-product-by-product-name/{name}")
    public ResponseEntity<Product> findProductIdByProductName(String name) throws Exception {
        return new ResponseEntity<Product>(productService.findProductIdByproductname(name), HttpStatus.OK);
    }


}
