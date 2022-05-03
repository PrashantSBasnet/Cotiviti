package com.biddingsystem.controller;

import com.biddingsystem.dto.BidsDto;
import com.biddingsystem.dto.UserDto;
import com.biddingsystem.service.BidsService;
import com.biddingsystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private BidsService bidsService;


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/totalOfferBids")
    public ResponseEntity<Integer> totalOfferBids(){
        Integer sum = reportService.totalOfferBids();
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/totalPostedBids")
    public ResponseEntity<Integer> allPostedBids(){
        Integer sum = reportService.allPostedBids();
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/totalUsers")
    public ResponseEntity<Integer> sumAllUsers() {
        Integer sum = reportService.totalUsers();
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/findAllBids")
    public ResponseEntity<List<BidsDto>> getBids() {
        List<BidsDto> dtoList = bidsService.findAllBids();
        return new ResponseEntity<>(dtoList,HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/showAllUsers")
    public ResponseEntity<List<Map<String,Object>>> ShowAllUsers() {
        List<Map<String,Object>> allUsers = reportService.showAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }


}
