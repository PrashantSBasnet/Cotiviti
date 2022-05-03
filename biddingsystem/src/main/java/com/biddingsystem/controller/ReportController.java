package com.biddingsystem.controller;


import com.biddingsystem.service.BidsService;
import com.biddingsystem.service.ReportService;
import com.biddingsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ReportController {

    private final UserService userService;
    private final BidsService bidsService;


    @Autowired
    ReportService reportService;




    @GetMapping("/totalbids/{id}")
    public ResponseEntity<Integer> sumAllPostedBid(@PathVariable("id") Integer id) {
        Integer sum = reportService.totalPostedBids(id);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    @GetMapping("/total-bids-product/{id}")
    public ResponseEntity<Integer> totalBidsPerProduct(@PathVariable("id") Integer id) {
        Integer sum = reportService.totalBidsPerProduct(id);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }


    @GetMapping("/max-bid-user-product/{userId}")
    public ResponseEntity<Integer>maxBidOfferedForUserProduct(@PathVariable("userId") Integer userId){
        Integer sum = reportService.maxBidOfferedForUserProduct(userId);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }











}
