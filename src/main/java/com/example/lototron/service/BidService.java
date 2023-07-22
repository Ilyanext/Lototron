package com.example.lototron.service;

import com.example.lototron.model.BidModel;

public interface BidService {
    BidModel getInfoFirstBidder(int id);
    BidModel getNameByMaxCountBid(int id);
}
