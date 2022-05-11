package com.biddingsystem.service;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.dto.UserDto;
import com.biddingsystem.entity.Bids;

import java.util.List;
import java.util.Map;

public interface BidsService {

    BidsDto save(BidsDto bidsDto) throws Exception;

    List<Map<String,Object>> findAllBids();

    List<BidsDto> findbyStatus(String status);

    List<BidsDto> findAvailableBids(Integer id);

    List<BidsDto> searchBids(String search);

    List<Map<String,Object>> offersInMyPosts(Integer userId);


}
