package com.example.lototron.service;

import com.example.lototron.pojo.Lot;
import com.example.lototron.repository.BidRepository;
import com.example.lototron.repository.LotRepository;
import org.springframework.stereotype.Service;

@Service
public class LotServiceImpl implements LotService {
    private final LotRepository lotRepository;
    private final BidRepository bidRepository;

    public LotServiceImpl(LotRepository lotRepository, BidRepository bidRepository) {
        this.lotRepository = lotRepository;
        this.bidRepository = bidRepository;
    }

//    @Override
//    public void addLot(Lot lot) {
//        lotRepository.save(lot);
//    }


    @Override
    public Lot createLotSQL(String title, String description, int bidPrice) {
        return lotRepository.createLotSQL(title, description, bidPrice);
    }

}
