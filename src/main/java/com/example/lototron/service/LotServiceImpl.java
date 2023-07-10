package com.example.lototron.service;

import com.example.lototron.dto.LotDTO;
import com.example.lototron.pojo.Lot;
import com.example.lototron.pojo.Status;
import com.example.lototron.repository.BidRepository;
import com.example.lototron.repository.LotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotServiceImpl implements LotService {
    private final LotRepository lotRepository;
    private final BidRepository bidRepository;

    public LotServiceImpl(LotRepository lotRepository, BidRepository bidRepository) {
        this.lotRepository = lotRepository;
        this.bidRepository = bidRepository;
    }

    @Override
    public Lot createLot(String title, String description, int startPrice, String status, int bidPrice) {
        LotDTO lotDTO = new LotDTO(title, description, startPrice, status, bidPrice);
    Lot lot = LotDTO.toLot(lotDTO);
    lotRepository.save(lot);
    return lot;
    }

    @Override
    public void startedLot(int id) {
        lotRepository.getReferenceById(id).setStatus(String.valueOf(Status.STARTED));
    }

//    @Override
//    public void startedLot(int id) {
//        lotRepository.getById(id).setStatus(String.valueOf(Status.STARTED));
//        lotRepository.startedLot(id);
//    }
}
