package com.biddingsystem.controller;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.dto.UserDto;
import com.biddingsystem.entity.Bids;
import com.biddingsystem.entity.User;
import com.biddingsystem.service.BidsService;
import com.biddingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BidsController {

    @Autowired
    BidsService bidsService;

    @PostMapping("/postBid")
    public ResponseEntity<BidsDto> postBid (@RequestBody BidsDto bidsDto) throws Exception{
        return new ResponseEntity<BidsDto>(bidsService.save(bidsDto), HttpStatus.OK);
    }

    @GetMapping("/bids")
    public ResponseEntity<List<Bids>> getBids() {

        return new ResponseEntity<>(bidsService.findAll(), HttpStatus.OK);
    }


}
