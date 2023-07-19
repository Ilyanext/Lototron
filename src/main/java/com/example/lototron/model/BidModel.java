package com.example.lototron.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bid")
public class BidModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "bidder_name", nullable = false)
    private String bidderName;
    @Column(name = "bidder_date_time")
    private LocalDateTime localDateTime= LocalDateTime.now();
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id", nullable = false)
    private LotModel lotModel;

    public BidModel(String bidderName) {
        this.id = id;
        this.bidderName = bidderName;
        this.localDateTime = localDateTime;
        this.lotModel = lotModel;
    }

    public BidModel(int id, String bidderName, LocalDateTime localDateTime, LotModel lotModel) {
        this.id = id;
        this.bidderName = bidderName;
        this.localDateTime = localDateTime;
        this.lotModel = lotModel;
    }

    public BidModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LotModel getLotModel() {
        return lotModel;
    }

    public void setLotModel(LotModel lotModel) {
        this.lotModel = lotModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BidModel bidModel = (BidModel) o;
        return id == bidModel.id && bidderName.equals(bidModel.bidderName) && localDateTime.equals(bidModel.localDateTime) && lotModel.equals(bidModel.lotModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bidderName, localDateTime, lotModel);
    }
}
