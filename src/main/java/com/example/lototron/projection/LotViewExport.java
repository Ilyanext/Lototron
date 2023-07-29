package com.example.lototron.projection;

import com.example.lototron.model.Status;

public interface LotViewExport {
    int getLot_id();

    String getTitle();

    String getDescription();

    int getCurrent_price();

    Status getStatus();

    String getLastBidder();
}
