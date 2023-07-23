package com.example.lototron.service;

import com.example.lototron.dto.Bid;
import com.example.lototron.model.BidModel;

public interface BidService {
    Bid getInfoFirstBidder(int id);
    Bid getNameByMaxCountBid(int id);
}
