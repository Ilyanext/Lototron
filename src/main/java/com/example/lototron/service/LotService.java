package com.example.lototron.service;

import com.example.lototron.pojo.Lot;
import org.springframework.data.repository.query.Param;

public interface LotService {
    Lot createLotSQL( String title, String description,
                      int bidPrice);
//     void addLot(Lot lot);
}
