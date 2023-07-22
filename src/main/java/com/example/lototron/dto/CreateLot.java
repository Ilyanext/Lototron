package com.example.lototron.dto;

import com.example.lototron.model.LotModel;
import com.example.lototron.model.Status;

public class CreateLot {

    private String title;
    private String description;
    private int startPrice;
    private int bidPrice;
    private Status status;

    public CreateLot(String title, String description, int startPrice, Status status, int bidPrice) {
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
        this.status = status;
    }

    public CreateLot() {
    }

    public static CreateLot fromLot(LotModel lotModel) {
        CreateLot createLot = new CreateLot();
        createLot.setBidPrice(lotModel.getBidPrice());
        createLot.setDescription(lotModel.getDescription());
        createLot.setTitle(lotModel.getTitle());
        createLot.setStartPrice(lotModel.getStartPrice());
        createLot.setStatus(lotModel.getStatus());
        return createLot;
    }

    public static LotModel toLot(CreateLot createLot) {
        LotModel lotModel = new LotModel();
        lotModel.setBidPrice(createLot.getBidPrice());
        lotModel.setDescription(createLot.getDescription());
        lotModel.setTitle(createLot.getTitle());
        lotModel.setStartPrice(createLot.getStartPrice());
        lotModel.setStatus(createLot.getStatus());
        return lotModel;
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
}
