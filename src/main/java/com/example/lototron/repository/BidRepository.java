package com.example.lototron.repository;

import com.example.lototron.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<BidModel, Integer> {
    @Query(value = "select *from bid where lot_id = :id order by bidder_date_time limit 1", nativeQuery = true)
    BidModel getInfoFirstBidder(@Param("id") int id);

    @Query(value = "select *from bid where bidder_name= (select  bidder_name from bid where lot_id=:id " +
            "group by bidder_namename order by count(bidder_name) desc limit 1) limit 1", nativeQuery = true)
    BidModel getNameByMaxCountBid(@Param("id") int id);
}
