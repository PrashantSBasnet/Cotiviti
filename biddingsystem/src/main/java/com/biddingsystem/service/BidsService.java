package com.biddingsystem.service;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.dto.UserDto;
import com.biddingsystem.entity.Bids;

import java.util.List;

public interface BidsService {

    BidsDto save(BidsDto bidsDto) throws Exception;

    List<Bids> findAll();

}
