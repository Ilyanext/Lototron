package com.example.lototron.controller;

import com.example.lototron.model.BidModel;
import com.example.lototron.service.LotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lot")
public class BidController {
    private final LotService lotService;

    public BidController(LotService lotService) {
        this.lotService = lotService;
    }


    @GetMapping("/{id}/first")
    public BidModel getInfoFirstBedder(@PathVariable int id) {
        return  lotService.getInfoFirstBidder(id);
    }
    //Bid
    @GetMapping("/{id}/frequent")
    public BidModel getNameByMaxCountBid(@PathVariable int id) {
        return  lotService.getNameByMaxCountBid(id);
    }
}
