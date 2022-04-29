package com.biddingsystem.service;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.entity.Bids;
import com.biddingsystem.entity.Product;
import com.biddingsystem.entity.User;
import com.biddingsystem.repo.BidsRepo;
import com.biddingsystem.repo.ProductRepo;
import com.biddingsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BidsServiceImpl implements BidsService {

    @Autowired
    BidsRepo bidsRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;


    @Override
    public List<BidsDto> findAllBids() {
       List<Bids> bidsList = bidsRepo.findAllBids();

      return  BidsDto.builder().build().toDto(bidsList);

    }

    @Override
    public List<BidsDto> findbyStatus(String status) {
        List<Bids> bidsList = bidsRepo.findByStatus(status);
        return BidsDto.builder().build().toDto(bidsList);
    }

    @Override
    public List<BidsDto> findAvailableBids(Integer id) {
        List<Bids> bidsList = bidsRepo.findAvailabeBids(id);
        return BidsDto.builder().build().toDto(bidsList);
    }

    @Override
    public List<BidsDto> searchBids(String search) {
        List<Bids> bidsList = bidsRepo.searchBids(search);
        return BidsDto.builder().build().toDto(bidsList);
    }


    @Override
    public BidsDto save(BidsDto bidsDto) throws Exception {

        User user;
        Product product;
        Bids bids;

        if (bidsDto.getId() != null && bidsDto.getId() != 0) {
            bids = bidsRepo.findBidsById(bidsDto.getId()); //from repo, created by programmer
        } else {
            bids = new Bids();
        }

        bids.setId(bidsDto.getId());
        //bids.setProduct_name(bidsDto.getProduct_name());
        //bids.setProduct_description(bidsDto.getProduct_description());

        //value ayo
        System.out.println(bidsDto.getUserId());

        //this is fine value ayooo.
        System.out.println(bidsDto.getBid_status());

        if (userRepo.findUserById(bidsDto.getUserId())!=null & bidsDto.getUserId() != 0){
            bids.setBid_status(bidsDto.getBid_status());
        }
        bids.setBid_status(bidsDto.getBid_status());

        user = userRepo.findUserById(bidsDto.getUserId());

        product = productRepo.findProductsById(bidsDto.getProductId());

        bids.setUsers(user);
        bids.setProduct(product);

        bidsRepo.save(bids); // repo takes entity
        return bidsDto;
    }
}
