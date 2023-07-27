package com.example.lototron.projection;

import com.example.lototron.model.LotModel;

import java.time.LocalDateTime;

public interface BidView {
    String getBidderName();
    LocalDateTime getLocalDateTime();

}
