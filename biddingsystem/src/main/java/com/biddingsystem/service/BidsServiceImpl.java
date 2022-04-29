package com.biddingsystem.service;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.entity.Bids;
import com.biddingsystem.entity.User;
import com.biddingsystem.repo.BidsRepo;
import com.biddingsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.Console;
import java.util.List;
import java.util.Optional;

@Service
public class BidsServiceImpl implements BidsService {

    @Autowired
    BidsRepo bidsRepo;

    @Autowired
    UserRepo userRepo;


    @Override
    public List<Bids> findAll() {
        return (List<Bids>) bidsRepo.findAll();  //becasue directly fetching from repo
    }


    @Override
    public BidsDto save(BidsDto bidsDto) throws Exception {

        User user;

        Bids bids;
        if (bidsDto.getId() != null && bidsDto.getId() != 0) {
            bids = bidsRepo.findBidsById(bidsDto.getId()); //from repo, created by programmer
        } else {
            bids = new Bids();
        }

        bids.setId(bidsDto.getId());
        bids.setProduct_name(bidsDto.getProduct_name());
        bids.setProduct_description(bidsDto.getProduct_description());

        //null kina ayo?
        System.out.println(bidsDto.getUserId());

        //this is fine value ayooo.
        System.out.println(bidsDto.getBid_status());

//        if (userRepo.findUserById(bidsDto.getUserId())!=null){
//            bids.setBid_status("ok");
//        }


        bidsRepo.save(bids); // repo takes entity
        return bidsDto;
    }
}
