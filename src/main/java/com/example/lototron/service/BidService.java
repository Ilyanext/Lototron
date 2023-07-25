package com.example.lototron.service;

import com.example.lototron.dto.Bid;
import com.example.lototron.dto.BidProjectDTO;
import com.example.lototron.model.BidModel;
import com.example.lototron.projection.BidProjection;
import com.example.lototron.projection.BidView;

public interface BidService {
    Bid getInfoFirstBidder(int id);
    BidView getNameByMaxCountBid(int id);
}
