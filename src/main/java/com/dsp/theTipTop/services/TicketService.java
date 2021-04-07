package com.dsp.theTipTop.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dsp.theTipTop.entities.Ticket;
import com.dsp.theTipTop.repositories.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;

	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	public Optional<Ticket> findById(Long id) {
		return ticketRepository.findById(id);
	}

	@Transactional
	public ResponseEntity<String> save(@Valid Ticket pTicket) {
		Ticket ticket = ticketRepository.save(pTicket);
		if(ticket == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when saving the ticket");
		}
		return ResponseEntity.ok().body(ticket.getTicketId().toString());
	}

	@Transactional
	public ResponseEntity<String> delete(Long id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		if(ticket == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("non-existent ticket with id : "+ id );
		} 
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

}
