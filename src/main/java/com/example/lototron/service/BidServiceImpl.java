package com.example.lototron.service;

import com.example.lototron.dto.Bid;
import com.example.lototron.model.BidModel;
import com.example.lototron.model.LotModel;
import com.example.lototron.repository.BidRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class BidServiceImpl implements BidService {
    private final BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public Bid getInfoFirstBidder(int id) {
        Bid bid = Bid.fromBidder(bidRepository.getInfoFirstBidder(id));
        return bid;
    }

    @Override
    public Bid getNameByMaxCountBid(int id) {
        Bid bid = Bid.fromBidder(bidRepository.getNameByMaxCountBid(id));
        return bid;
    }
}
