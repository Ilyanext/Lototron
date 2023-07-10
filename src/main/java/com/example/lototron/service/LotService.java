package com.example.lototron.service;

import com.example.lototron.pojo.Lot;
import org.springframework.web.bind.annotation.PathVariable;

public interface LotService {
    Lot createLot(String title, String description, int startPrice, String status, int bidPrice);
    void startedLot(@PathVariable int id);
}
