package com.example.lototron.service;

import com.example.lototron.ExeptionHandler.NotIdExeption;
import com.example.lototron.ExeptionHandler.StatusExeption;
import com.example.lototron.dto.CreateLot;
import com.example.lototron.dto.FullLot;
import com.example.lototron.model.BidModel;
import com.example.lototron.model.LotModel;
import com.example.lototron.model.Status;
import com.example.lototron.repository.BidRepository;
import com.example.lototron.repository.LotRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public CreateLot createLot(String title, String description, int startPrice, Status status, int bidPrice) {
        CreateLot createLot = new CreateLot(title, description, startPrice, status, bidPrice);
        LotModel lotModel = CreateLot.toLot(createLot);
        lotRepository.save(lotModel);
        return createLot;
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
            bidModel.setLotModel(lotModel);
            bidRepository.save(bidModel);
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
    public List<LotModel> getLotByStatusAndPage(Status status, int page) { //?
        PageRequest pageable =  PageRequest.of(page, 10);
        Page<LotModel> lotPage = lotRepository.findAll(pageable);

        return lotPage.stream().filter(lot -> lot.getStatus().equals(status)).collect(Collectors.toList());
    }

    @Override
    public FullLot getFullLot(int id) {
        return lotRepository.findById(id).stream().map(FullLot::fromLot).findFirst().orElseThrow(() -> {
            return new NotIdExeption("Lot not found!");});

    }

 }
