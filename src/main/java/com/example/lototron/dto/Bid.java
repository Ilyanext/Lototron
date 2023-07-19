package com.example.lototron.dto;

import com.example.lototron.model.BidModel;
import com.example.lototron.model.LotModel;

import java.time.LocalDateTime;

public class Bid {
    private int id;
    private String bidderName;
    private LocalDateTime localDateTime;
    private Lot lot;

    public Bid() {
    }

    public Bid(int id, String bidderName, LocalDateTime localDateTime) {
        this.id = id;
        this.bidderName = bidderName;
        this.localDateTime = localDateTime;
        this.lot = lot;
    }

    public static Bid fromBidder (BidModel bidModel){
        Bid bid = new Bid();
        bid.setId(bidModel.getId());
        bid.setBidderName(bidModel.getBidderName());
        bid.setLocalDateTime(bidModel.getLocalDateTime());
        var lot = bidModel.getLotModel();
        var lotDTO = new Lot(lot.getTitle(),lot.getDescription(),lot.getId(),lot.getStatus(),lot.getBidPrice());
        bid.setLot(lotDTO);
        return bid;
    }

    public static BidModel toBid(Bid bid) {
        BidModel bidModel = new BidModel();
        bidModel.setId(bid.getId());
        bidModel.setBidderName(bid.getBidderName());
        bidModel.setLocalDateTime(bid.getLocalDateTime());

        Lot lotDTO = bid.getLot();
        var lot = new LotModel();
        lot.setId(lotDTO.getId());
        lot.setTitle(lot.getTitle());
        lot.setDescription(lot.getDescription());
        lot.setStatus(lot.getStatus());
        lot.setBidPrice(lot.getBidPrice());

        return bidModel;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "BidderDTO{" +
                "id=" + id +
                ", bidderName='" + bidderName + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
