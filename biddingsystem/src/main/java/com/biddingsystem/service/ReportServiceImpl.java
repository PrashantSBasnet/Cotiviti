package com.biddingsystem.service;

import com.biddingsystem.repo.BidsRepo;
import com.biddingsystem.repo.ProductRepo;
import com.biddingsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        return userRepo.totalBidsUser(userId);
    }

    @Override
    public Integer totalBidsPerProduct(Integer id) {
        return bidsRepo.totalBidsPerProduct(id);
    }

    @Override
    public Integer maxBidOfferedForUserProduct(Integer userId) {
        return productRepo.maxBidOfferedForUserProduct(userId);
    }

    @Override
    public Integer totalUsers() {
        return userRepo.sumAllUsers();
    }

    @Override
    public Integer totalOfferBids() {
        return userRepo.totalOfferBids();
    }

    @Override
    public Integer allPostedBids() {
        return userRepo.totalPostedBids();
    }

    @Override
    public List<Map<String, Object>> showAllUsers() {
        return userRepo.displayAllUsers();
    }
}
