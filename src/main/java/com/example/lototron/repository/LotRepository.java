package com.example.lototron.repository;

import com.example.lototron.dto.FullLot;
import com.example.lototron.model.LotModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends JpaRepository<LotModel, Integer> {
    @Query(value = "select l.lot_id as lot_id, l.title, l.bid_price as bid_price, l.start_price as start_price, l.description, l.status, \n " +
            "(start_price+bid_price*(select count(lot_id) from bid b where b.lot_id=lot_id)) as current_price, \n" +
            "b2.bidder_name, b2.bidder_date_time from lot l inner join bid b2 on l.lot_id = 2 and b2.bidder_date_time = (select max(b3.bidder_date_time) from bid b3 where b3.lot_id = :id)", nativeQuery = true)
    FullLot getFullLot(@Param("id") int id);

    Page<LotModel> findAll(Pageable pageable);
}
