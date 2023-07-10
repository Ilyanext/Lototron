package com.example.lototron.repository;

import com.example.lototron.pojo.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends JpaRepository<Lot, Integer> {
//    @Modifying
//    @Query(value = "insert into lot ( title, description, status, start_price, bid_price)" +
//            "values (:title, :description , 'STARTED', 100,:bid_price)", nativeQuery = true)
//    void createLotSQL(@Param("title") String title, @Param("description") String description,
//                      @Param("bid_price") int bidPrice);
//    @Modifying
//    @Query(value = "update lot set status = 'STARTED' where lot_id=:id", nativeQuery = true)
//    void startedLot(@Param("id") int id);
}
