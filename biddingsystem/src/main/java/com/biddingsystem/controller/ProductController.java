package com.biddingsystem.controller;

import com.biddingsystem.dto.ProductDto;
import com.biddingsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) throws Exception {
        return new ResponseEntity<ProductDto>(productService.save(productDto), HttpStatus.OK);
    }

}
