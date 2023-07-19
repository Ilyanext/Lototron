package com.example.lototron.controller;

import com.example.lototron.dto.FullLot;
import com.example.lototron.dto.Lot;
import com.example.lototron.model.BidModel;
import com.example.lototron.model.LotModel;
import com.example.lototron.model.Status;
import com.example.lototron.service.LotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.lototron.model.Status.CREATED;


@RestController
@RequestMapping("/lot")
public class LotController {
    private final LotService lotService;

    public LotController(LotService lotService) {
        this.lotService = lotService;
    }

    @GetMapping("/{id}")
    public FullLot getAllInfoLot(@PathVariable int id) {
        return lotService.getFullLot(id);
    }

    @PostMapping("/")
    public LotModel createdLot(String title, String description, int startPrice, int bidPrice) {
        System.out.println("Лот успешно создан");
        return lotService.createLot(title, description, startPrice, Status.CREATED, bidPrice);
    }

    @PostMapping("/{id}/start")
    public void startedLot(@PathVariable int id) {
        lotService.startedLot(id);
    }

    @PostMapping("/{id}/bid")
    public void placeBidOnLot(@PathVariable int id, @RequestParam("bidder_name") String bidderName) {
          lotService.createNewBidForLot(id, bidderName);
    }

    @PostMapping("/{id}/stop")
    public void stoppedLot(@PathVariable int id) {
        lotService.stoppedLot(id);
    }

    @GetMapping("/")
    public List<Lot> getAllInfoLotByStatusAndNumberPage(@RequestParam("status") Status status,
                                                        @RequestParam("page") int page) {
        return lotService.getLotByStatusAndPage(status, page);
    }

    //Нужно возвращать файл
    @GetMapping("/export")
    public int getExportAllLotInFile() {
        return 333;
    }
}
