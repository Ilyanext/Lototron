package com.example.lototron.dto;

import com.example.lototron.model.LotModel;
import com.example.lototron.model.Status;
import com.example.lototron.projection.LotViewExport;

import java.util.Objects;

public class LotExportDTO {
    private int Lot_id;
    private String title;
    private String description;
    private String lastBedder;
    private int currentPrice;
    private Status status;


    public LotExportDTO(int lot_id, String title, String description, String lastBedder, int currentPrice, Status status) {
        Lot_id = lot_id;
        this.title = title;
        this.description = description;
        this.lastBedder = lastBedder;
        this.currentPrice = currentPrice;
        this.status = status;
    }

    public LotExportDTO() {
    }

    public static LotExportDTO fromLot(LotViewExport lotModel) {
        LotExportDTO lot = new LotExportDTO();
        lot.setCurrentPrice(lotModel.getCurrent_price());
        lot.setTitle(lotModel.getTitle());
        lot.setDescription(lotModel.getDescription());
        lot.setLastBedder(lotModel.getLastBidder());
        lot.setStatus(lotModel.getStatus());
        return lot;
    }

    public static LotModel toLot(LotExportDTO lot) {
        LotModel lotModel = new LotModel();

        lotModel.setTitle(lot.getTitle());
        lotModel.setDescription(lot.getDescription());

        lotModel.setStatus(lot.getStatus());
        return lotModel;
    }

    public int getLot_id() {
        return Lot_id;
    }

    public void setLot_id(int lot_id) {
        Lot_id = lot_id;
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

    public String getLastBedder() {
        return lastBedder;
    }

    public void setLastBedder(String lastBedder) {
        this.lastBedder = lastBedder;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotExportDTO that = (LotExportDTO) o;
        return Lot_id == that.Lot_id && currentPrice == that.currentPrice && title.equals(that.title) && description.equals(that.description) && lastBedder.equals(that.lastBedder) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Lot_id, title, description, lastBedder, currentPrice, status);
    }

    @Override
    public String toString() {
        return "LotExportDTO{" +
                "Lot_id=" + Lot_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", lastBedder='" + lastBedder + '\'' +
                ", currentPrice=" + currentPrice +
                ", status=" + status +
                '}';
    }
}
