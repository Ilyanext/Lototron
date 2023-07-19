package com.example.lototron.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lot")
public class LotModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_id", nullable = false)
    private int id;
    @Min(3)
    @Max(64)
    private String title;
    @Min(1)
    @Max(4096)
    private String description;
    @Min(1)
    @Column(name = "start_price")
    private int startPrice;
    @Min(1)
    @Column(name = "bid_price")
    private int bidPrice;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @OneToMany(mappedBy = "lotModel")
    private List<BidModel> bidModelList;

    public LotModel(int id, String title, String description, int startPrice, int bidPrice, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
        this.status = status;
    }

    public LotModel() {

    }

    public int getId() {
        return this.id;
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

    public Status setStatus(Status status) {
        this.status = status;
        return status;
    }

    public List<BidModel> getBidList() {
        return bidModelList;
    }

    public void setBidList(List<BidModel> bidModelList) {
        this.bidModelList = bidModelList;
    }


}
