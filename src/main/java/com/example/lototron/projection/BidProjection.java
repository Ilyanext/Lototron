package com.example.lototron.projection;

import com.example.lototron.dto.Lot;
import com.example.lototron.model.BidModel;

import java.time.LocalDateTime;

public class BidProjection  {
    private String bidderName;
    private LocalDateTime localDateTime;


    public BidProjection(String bidderName, LocalDateTime localDateTime) {
        this.bidderName = bidderName;
        this.localDateTime = localDateTime;

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
}
