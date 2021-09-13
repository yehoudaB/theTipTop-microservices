package com.dsp.theTipTop.test.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsp.theTipTop.entities.Ticket;
import com.dsp.theTipTop.services.TicketService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE) 
@TestPropertySource(locations = "/application-local.properties") //for local test
class TicketServiceIntegrationTest {

	@Autowired
	private TicketService ticketService;
	
	
	@Test
	void testAddTicket() {
		Ticket ticket  = new Ticket();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 99999 + 1);
		ticket.setTicketId((long) randomNum);
		ticket.setName("Ticket de test 1");
		ticket.setHadTheGift(true);
		
		
		
		ResponseEntity<String> savedTicketId = ticketService.save(ticket);
		System.out.println(savedTicketId.getBody());
		assertNotNull(savedTicketId);
		assertThat(Integer.parseInt(savedTicketId.getBody())).isBetween(1, 99999);
	}
	
	

}
