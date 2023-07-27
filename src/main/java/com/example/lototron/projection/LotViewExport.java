package com.example.lototron.projection;

import com.example.lototron.model.Status;

public interface LotViewExport {
    int getId();

    String getTitle();

    String getDescription();

    Status getStatus();
}
