package com.example.lototron.projections;

import java.time.LocalDateTime;

public class Bidder {
    private String bidderName;
    private LocalDateTime localDateTime;

    public Bidder(String bidderName, LocalDateTime localDateTime) {
        this.bidderName = bidderName;
        this.localDateTime = localDateTime;
    }

    public Bidder() {
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
        return "Bidder{" +
                "bidderName='" + bidderName + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
