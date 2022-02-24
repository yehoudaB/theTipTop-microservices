package com.dsp.theTipTop.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dsp.theTipTop.entities.Lot;
import com.dsp.theTipTop.entities.Ticket;
import com.dsp.theTipTop.repositories.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	LotService lotService;

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
		try {
			ticketRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("non-existent user with id : "+ id );
	}

	


	public String generateTicket(double price) {
	
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	       
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		String month = Integer.toString(calendar.get(Calendar.MONTH)+1);
		String day =  Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
		String hour =  Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
		String minute =  Integer.toString(calendar.get(Calendar.MINUTE));
		String second =  Integer.toString(calendar.get(Calendar.SECOND));
		String millisecond =  Integer.toString(calendar.get(Calendar.MILLISECOND));
		String dateInNumber = month + day + hour + minute +second + millisecond;
	    String ticketNumber = dateInNumber + Math.round(price);
	    
	    int randomNum = ThreadLocalRandom.current().nextInt(1, 99999 + 1);
	   
	    Lot lot = new  Lot();
	    lot = lotService.findById((long) 1).get();
	    
	
	    Ticket ticket = new Ticket(ticketNumber,lot, null, false);
	    
	    this.save(ticket);
	   
	    return ticketNumber;
	}
	

}
