package com.example.lototron.repository;

import com.example.lototron.model.BidModel;
import com.example.lototron.projection.BidView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<BidModel, Integer> {

    @Query(value = "select *from bid where lot_id = :id order by bidder_date_time limit 1", nativeQuery = true)
    BidModel getInfoFirstBidder(@Param("id") int id);

    @Query(value = "select bidder_name as  bidderName, MAX(bidder_date_time ) as localDateTime   from bid where lot_id=:id " +
            "group by bidderName  order by count(*) desc limit 1", nativeQuery = true)
    BidView getNameByMaxCountBid(@Param("id") int id);
}
