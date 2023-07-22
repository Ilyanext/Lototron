package com.example.lototron.controller;

import com.example.lototron.model.BidModel;
import com.example.lototron.service.BidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lot")
public class BidController {

private final  BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }


    @GetMapping("/{id}/first")
    public BidModel getInfoFirstBedder(@PathVariable int id) {
        return bidService.getInfoFirstBidder(id);
    }

    //Bid
    @GetMapping("/{id}/frequent")
    public BidModel getNameByMaxCountBid(@PathVariable int id) {
        return bidService.getNameByMaxCountBid(id);
    }
}
