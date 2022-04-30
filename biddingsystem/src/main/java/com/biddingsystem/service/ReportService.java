package com.biddingsystem.service;

public interface ReportService {

    Integer totalPostedBids(Integer userId);


    Integer totalBidsPerProduct(Integer id);

    Integer maxBidOfferedForUserProduct(Integer userId);
}
