package com.example.lototron.repository;

import com.example.lototron.pojo.Bid;
import com.example.lototron.pojo.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends JpaRepository<Lot,Integer> {
}
