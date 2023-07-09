package com.example.lototron.controller;

import com.example.lototron.service.LotService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lot")
public class LotController {
    private final LotService lotService;

    public LotController(LotService lotService) {
        this.lotService = lotService;
    }

    @GetMapping("/{id}/first")
    public int getInfoFirstBedder(@PathVariable String id) {
        return 1;
    }

    @GetMapping("/{id}/frequent")
    public void getNameByMaxCountBid(@PathVariable String id) {
        System.out.println("getNameByMaxCountBid");
    }

    @GetMapping("/{id}")
    public int getAllInfoLot(@PathVariable String id) {
        return 999;
    }

    @PostMapping("/")
    public void createdLot(){
        lotService.createdLot();
    }
    @PostMapping("/{id}/start")
    public void startedLot(@PathVariable String id){
        System.out.println("ok.startedLot");
    }
    @PostMapping("/{id}/bid")
    public void placeBidOnLot(@PathVariable String id){
        System.out.println("ok.placeBidOnLot");
    }
    @PostMapping("/{id}/stop")
    public void stoppedLot(@PathVariable String id){
        System.out.println("ok.stoppedLot");
    }
    @GetMapping("/")
    public int getAllInfoLotByStatusAndNumberPage() {
        return 222;
    }
    @GetMapping("/export")
    public int getExportAllLotInFile() {
        return 333;
    }
}
