package com.biddingsystem.controller;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.service.BidsService;
import com.biddingsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BidsController {

    @Autowired
    BidsService bidsService;

    @Autowired
    ProductService productService;

    @PostMapping("/postBid")
    public ResponseEntity<BidsDto> postBid (@RequestBody BidsDto bidsDto) throws Exception{
        return new ResponseEntity<BidsDto>(bidsService.save(bidsDto), HttpStatus.OK);
    }



    @GetMapping("/find-by-status/{status}")
    public ResponseEntity<List<BidsDto>> findByStatus(@PathVariable("status") String status) throws Exception{
        List<BidsDto> dtoList = bidsService.findbyStatus(status);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    @GetMapping("/find-available/{id}")
    public ResponseEntity<List<BidsDto>>findAvailableBids(@PathVariable("id") Integer id) throws Exception{
        List<BidsDto> dtoList = bidsService.findAvailableBids(id);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    @GetMapping("/search-bids/{search}")
    public ResponseEntity<List<BidsDto>>searchBids(@PathVariable("search") String search) {
        List<BidsDto> dtoList = bidsService.searchBids(search);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    @GetMapping("/showAllPostedBids")
    public ResponseEntity<List<Map<String,Object>>> showAllPostedBids (){
        List<Map<String,Object>> allPostedBids = productService.showAllPostedBids();
        return new ResponseEntity<>(allPostedBids, HttpStatus.OK);
    }


    @GetMapping("/offerInMyPosts/{userId}")
    public ResponseEntity<List<Map<String,Object>>> offersInMyPosts (@PathVariable("userId")  Integer userId){
        List<Map<String,Object>> offersInMyPosts = bidsService.offersInMyPosts(userId);
        return new ResponseEntity<>(offersInMyPosts, HttpStatus.OK);
    }






}
