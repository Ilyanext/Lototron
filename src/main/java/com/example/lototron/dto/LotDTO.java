package com.example.lototron.dto;

import com.example.lototron.pojo.Lot;

public class LotDTO {
    private int id;
    private String title;
    private String description;
    private int startPrice;
    private int bidPrice;

    private String status;
    public LotDTO(String title, String description, int startPrice, String status, int bidPrice) {

        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
        this.status = status;
    }

    public LotDTO() {
    }



    public static  LotDTO fromLot (Lot lot){
        LotDTO lotDTO = new LotDTO();
        lotDTO.setId(lot.getId());
        lotDTO.setTitle(lot.getTitle());
        lotDTO.setDescription(lot.getDescription());
        lotDTO.setStartPrice(lot.getStartPrice());
        lotDTO.setBidPrice(lot.getBidPrice());
        lotDTO.setStatus(lot.getStatus());
        return lotDTO;
    }

   

    public static Lot toLot(LotDTO lotDTO) {
        Lot lot = new Lot();
        lot.setId(lotDTO.getId());
        lot.setTitle(lotDTO.getTitle());
        lot.setDescription(lotDTO.getDescription());
        lot.setStartPrice(lotDTO.getStartPrice());
        lot.setBidPrice(lotDTO.getBidPrice());
        lot.setStatus(lotDTO.getStatus());
        return lot;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
