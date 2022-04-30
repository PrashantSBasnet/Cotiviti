package com.biddingsystem.service;

import com.biddingsystem.repo.BidsRepo;
import com.biddingsystem.repo.ProductRepo;
import com.biddingsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    BidsRepo bidsRepo;

    @Autowired
    ProductRepo productRepo;

    @Override
    public Integer totalPostedBids(Integer userId) {
        return userRepo.totalBids(userId);
    }

    @Override
    public Integer totalBidsPerProduct(Integer id) {
        return bidsRepo.totalBidsPerProduct(id);
    }

    @Override
    public Integer maxBidOfferedForUserProduct(Integer userId) {
        return productRepo.maxBidOfferedForUserProduct(userId);
    }
}
