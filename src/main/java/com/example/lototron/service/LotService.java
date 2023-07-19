package com.example.lototron.service;

import com.example.lototron.dto.FullLot;
import com.example.lototron.dto.Lot;
import com.example.lototron.model.BidModel;
import com.example.lototron.model.LotModel;
import com.example.lototron.model.Status;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LotService {
    LotModel createLot(String title, String description, int startPrice, Status status, int bidPrice);

    void startedLot(@PathVariable int id);

    void createNewBidForLot(@PathVariable int id, @RequestParam("bidder_name") String bidderName);

    void stoppedLot(@PathVariable int id);

    List<Lot> getLotByStatusAndPage(Status status, int page);

    FullLot getFullLot(int id);

    BidModel getInfoFirstBidder(@PathVariable int id);

    BidModel getNameByMaxCountBid(@PathVariable int id);
}
