package com.dsp.theTipTop.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dsp.theTipTop.entities.Lot;
import com.dsp.theTipTop.repositories.LotRepository;

@Service
public class LotService {
	
	@Autowired
	LotRepository lotRepository;

	public List<Lot> findAll() {
		return lotRepository.findAll();
	}

	public Optional<Lot> findById(Long id) {
		return lotRepository.findById(id);
	}

	@Transactional
	public ResponseEntity<String> save(@Valid Lot pLot) {
		Lot lot = lotRepository.save(pLot);
		if(lot == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when saving the lot");
		}
		return ResponseEntity.ok().body(lot.getId().toString());
	}

	@Transactional
	public ResponseEntity<String> delete(Long id) {
		try {
			lotRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("non-existent user with id : "+ id );
	}

}
