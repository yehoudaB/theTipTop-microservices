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

import com.dsp.theTipTop.entities.Ticket;
import com.dsp.theTipTop.services.TicketService;

@RestController
@RequestMapping(value = {"/tickets"})
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping()
	public List<Ticket> readAll() {
		return ticketService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Ticket> read(@PathVariable Long id) {
		return ticketService.findById(id);	
	}
	
	
	@PostMapping
	public ResponseEntity<String> save(@Valid @RequestBody Ticket ticket){
		return ticketService.save(ticket);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return ticketService.delete(id);
	}
}
