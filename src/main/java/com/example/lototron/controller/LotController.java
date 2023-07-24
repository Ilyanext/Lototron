package com.example.lototron.controller;

import com.example.lototron.dto.CreateLot;
import com.example.lototron.dto.FullLot;
import com.example.lototron.dto.Lot;

import com.example.lototron.model.LotModel;
import com.example.lototron.model.Status;
import com.example.lototron.service.LotService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;



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
    public CreateLot createdLot(String title, String description, int startPrice, int bidPrice) {
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
    public void getExportAllLotInFile(HttpServletResponse response) throws IOException {
        response.addHeader(HttpHeaders.CONTENT_TYPE, "application/csv");
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "LotInfo.csv" + "\"");
        lotService.csvFile(response.getWriter());

    }
}
