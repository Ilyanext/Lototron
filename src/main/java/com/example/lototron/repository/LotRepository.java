package com.example.lototron.repository;

import com.example.lototron.model.LotModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends JpaRepository<LotModel, Integer> {
//    @Modifying
//    @Query(value = "insert into lot ( title, description, status, start_price, bid_price)" +
//            "values (:title, :description , 'STARTED', 100,:bid_price)", nativeQuery = true)
//    void createLotSQL(@Param("title") String title, @Param("description") String description,
//                      @Param("bid_price") int bidPrice);
//    @Modifying
//    @Query(value = "update lot set status = 'STARTED' where lot_id=:id", nativeQuery = true)
//    void startedLot(@Param("id") int id);

//    @Modifying
//    @Query(value = "insert into bid ( lot_id, bidder_name)" +
//            "values (:lot_id, :bidder_name )", nativeQuery = true)
//    void createNewBidForLot(@Param("lot_id") int id, @Param("bidder_name") String name);
}
