package com.example.lototron.dto;

import com.example.lototron.model.BidModel;
import com.example.lototron.model.LotModel;
import com.example.lototron.model.Status;

public class FullLot {
    private int id;
    private Status status;
    private String title;
    private String description;
    private int startPrice;
    private int bidPrice;
    private int currentPrice;
    private BidModel bidModel;

    public static FullLot fromLot(LotModel lotModel) {
        FullLot fullLot = new FullLot();
        fullLot.setId(lotModel.getId());
        fullLot.setStatus(lotModel.getStatus());
        fullLot.setTitle(lotModel.getTitle());
        fullLot.setDescription(lotModel.getDescription());
        fullLot.setStartPrice(lotModel.getStartPrice());
        fullLot.setBidPrice(lotModel.getBidPrice());
        fullLot.setCurrentPrice(fullLot.getCurrentPrice());
        return fullLot;

    }

    public LotModel toLot(FullLot fullLot) {
        LotModel lotModel = new LotModel();
        lotModel.setId(this.getId());
        lotModel.setStatus(this.getStatus());
        lotModel.setTitle(this.getTitle());
        lotModel.setDescription(this.getDescription());
        lotModel.setStartPrice(this.getStartPrice());
        lotModel.setBidPrice(this.getBidPrice());
        return lotModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BidModel getBid() {
        return bidModel;
    }

    public void setBid(BidModel bidModel) {
        this.bidModel = bidModel;
    }
}
