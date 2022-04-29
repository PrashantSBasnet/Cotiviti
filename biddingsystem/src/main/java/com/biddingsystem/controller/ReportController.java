package com.biddingsystem.controller;

import com.biddingsystem.service.BidsService;
import com.biddingsystem.service.ReportService;
import com.biddingsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ReportController {

    private final UserService userService;
    private final BidsService bidsService;
    private final ReportService reportService;


    @GetMapping("/totalbids/{id}")
    public ResponseEntity<Integer> totalBids(@PathVariable("id") Integer id) {
        Integer sum = reportService.totalPostedBids(id);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }


}
