package com.example.lototron.service;

import com.example.lototron.ExeptionHandler.NotIdExeption;
import com.example.lototron.ExeptionHandler.StatusExeption;
import com.example.lototron.dto.FullLot;
import com.example.lototron.dto.Lot;
import com.example.lototron.model.BidModel;
import com.example.lototron.model.LotModel;
import com.example.lototron.model.Status;
import com.example.lototron.repository.BidRepository;
import com.example.lototron.repository.LotRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class LotServiceImpl implements LotService {
    private final LotRepository lotRepository;
    private final BidRepository bidRepository;

    public LotServiceImpl(LotRepository lotRepository, BidRepository bidRepository) {
        this.lotRepository = lotRepository;
        this.bidRepository = bidRepository;
    }

    @Override
    public LotModel createLot(String title, String description, int startPrice, Status status, int bidPrice) {
        Lot lot = new Lot(title, description, startPrice, status, bidPrice);
        LotModel lotModel = Lot.toLot(lot);
        lotRepository.save(lotModel);
        return lotModel;
    }


    @Override
    public void startedLot(int id) {
        LotModel lotModel = lotRepository.findById(id).orElseThrow(() -> {
            return new NotIdExeption("Lot not found!");
        });
        lotModel.setStatus(Status.STARTED);
        lotRepository.save(lotModel);
    }

    @Override
    public void createNewBidForLot(int id, String bidderName) {
        LotModel lotModel = lotRepository.findById(id).orElseThrow(() -> {
            return new NotIdExeption("Lot not found!");
        });
        if (lotModel.getStatus().equals(Status.STARTED)) {
            BidModel bidModel = new BidModel(bidderName);
            List<BidModel> bidModelList = new ArrayList<>(lotModel.getBidList());
            bidModelList.add(bidModel);
            lotModel.setBidList(bidModelList);

            bidRepository.save(bidModel);
            lotRepository.save(lotModel);
        } else throw new StatusExeption("Status not correct");
    }

    @Override
    public void stoppedLot(int id) {
        LotModel lotModel = lotRepository.findById(id).orElseThrow(() -> {
            return new NotIdExeption("Lot not found!");
        });
        lotModel.setStatus(Status.STOPPED);
        lotRepository.save(lotModel);
    }

    @Override
    public List<Lot> getLotByStatusAndPage(Status status, int page) {
        Pageable pageable = (Pageable) PageRequest.of(page, 10);
        Page<LotModel> lotPage = lotRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<Lot> lots = lotPage.stream().map(Lot::fromLot).collect(Collectors.toList());
        return lots.stream().filter(lot -> lot.getStatus().equals(status)).collect(Collectors.toList());
    }

    @Override
    public FullLot getFullLot(int id) {
        LotModel lotModel = lotRepository.findById(id).
                orElseThrow(() -> {
                    return new NotIdExeption("Lot not found!");
                });

        return FullLot.fromLot(lotModel);
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
