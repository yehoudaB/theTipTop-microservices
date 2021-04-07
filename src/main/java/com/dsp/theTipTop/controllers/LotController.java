package com.dsp.theTipTop.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsp.theTipTop.entities.Lot;
import com.dsp.theTipTop.services.LotService;

@RestController
@RequestMapping(value = {"/lots"})
public class LotController {
	
	@Autowired
	LotService lotService;
	
	@GetMapping()
	public List<Lot> readAll() {
		return lotService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Lot> read(@PathVariable Long id) {
		return lotService.findById(id);	
	}
	
	
	@PostMapping()
	public ResponseEntity<String> save(@Valid @RequestBody Lot lot){
		return lotService.save(lot);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return lotService.delete(id);
	}
}
