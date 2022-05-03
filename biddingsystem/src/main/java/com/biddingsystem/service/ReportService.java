package com.biddingsystem.service;

import java.util.List;
import java.util.Map;

public interface ReportService {

    Integer totalPostedBids(Integer userId);


    Integer totalBidsPerProduct(Integer id);

    Integer maxBidOfferedForUserProduct(Integer userId);

    Integer totalUsers();

    Integer totalOfferBids();

    Integer allPostedBids();

    List<Map<String,Object>> showAllUsers();
}
