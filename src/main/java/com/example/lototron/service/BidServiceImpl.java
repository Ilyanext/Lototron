package com.example.lototron.service;

import com.example.lototron.model.BidModel;
import com.example.lototron.repository.BidRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class BidServiceImpl implements BidService{
    private  final BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public BidModel getInfoFirstBidder(int id) {
        return bidRepository.getInfoFirstBidder(id);
    }

    @Override
    public BidModel getNameByMaxCountBid(int id) {
        return bidRepository.getNameByMaxCountBid(id);
    }
}
