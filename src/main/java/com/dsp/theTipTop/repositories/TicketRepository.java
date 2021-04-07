package com.dsp.theTipTop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsp.theTipTop.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
}
