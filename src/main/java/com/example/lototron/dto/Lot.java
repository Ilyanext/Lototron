package com.example.lototron.dto;

import com.example.lototron.model.LotModel;
import com.example.lototron.model.Status;

public class Lot {
    private int id;
    private String title;
    private String description;
    private int startPrice;
    private int bidPrice;

    private Status status;
    public Lot(String title, String description, int startPrice, Status status, int bidPrice) {

        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
        this.status = status;
    }

    public Lot() {
    }

    public static Lot fromLot (LotModel lotModel){
        Lot lot = new Lot();
        lot.setId(lotModel.getId());
        lot.setTitle(lotModel.getTitle());
        lot.setDescription(lotModel.getDescription());
        lot.setStartPrice(lotModel.getStartPrice());
        lot.setBidPrice(lotModel.getBidPrice());
        lot.setStatus(lotModel.getStatus());
        return lot;
    }

    public static LotModel toLot(Lot lot) {
        LotModel lotModel = new LotModel();
        lotModel.setId(lot.getId());
        lotModel.setTitle(lot.getTitle());
        lotModel.setDescription(lot.getDescription());
        lotModel.setStartPrice(lot.getStartPrice());
        lotModel.setBidPrice(lot.getBidPrice());
        lotModel.setStatus(lot.getStatus());
        return lotModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
