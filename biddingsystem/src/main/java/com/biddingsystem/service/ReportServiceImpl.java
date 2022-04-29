package com.biddingsystem.service;

import com.biddingsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    UserRepo userRepo;

    @Override
    public Integer totalPostedBids(Integer userId) {
        return userRepo.totalBids(userId);
    }
}
