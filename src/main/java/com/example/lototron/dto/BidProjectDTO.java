package com.example.lototron.dto;

import com.example.lototron.model.BidModel;
import com.example.lototron.model.LotModel;

import java.time.LocalDateTime;

public class BidProjectDTO {

    private String bidderName;
    private LocalDateTime localDateTime;


    public static BidProjectDTO fromBidder(BidModel bidModel) {
        BidProjectDTO bid = new BidProjectDTO();

        bid.setBidderName(bidModel.getBidderName());
        bid.setLocalDateTime(bidModel.getLocalDateTime());
        return bid;
    }

    public static BidModel toBid(BidProjectDTO bidProjectDTO) {
        BidModel bidModel = new BidModel();

        bidModel.setBidderName(bidProjectDTO.getBidderName());
        bidModel.setLocalDateTime(bidProjectDTO.getLocalDateTime());
        return bidModel;
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

                ", bidderName='" + bidderName + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}


