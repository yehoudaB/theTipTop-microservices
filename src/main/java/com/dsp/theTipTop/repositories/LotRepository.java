package com.dsp.theTipTop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsp.theTipTop.entities.Lot;

@Repository
public interface LotRepository extends JpaRepository<Lot, Long> {
	
}
