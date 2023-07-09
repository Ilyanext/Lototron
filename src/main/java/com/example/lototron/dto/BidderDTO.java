package com.example.lototron.dto;

import com.example.lototron.pojo.Bid;
import com.example.lototron.pojo.Lot;

import java.time.LocalDateTime;

public class BidderDTO {
    private int id;
    private String bidderName;
    private LocalDateTime localDateTime;


    public static BidderDTO fromBidder (Bid bid){
        BidderDTO bidderDTO = new BidderDTO();
        bidderDTO.setId(bid.getId());
        bidderDTO.setBidderName(bid.getBidderName());
        bidderDTO.setLocalDateTime(bid.getLocalDateTime());
        return bidderDTO;
    }

    public static Bid toBid(BidderDTO bidderDTO) {
        Bid bid = new Bid();
        bid.setId(bidderDTO.getId());
        bid.setBidderName(bidderDTO.getBidderName());
        bid.setLocalDateTime(bidderDTO.getLocalDateTime());
        return bid;
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
