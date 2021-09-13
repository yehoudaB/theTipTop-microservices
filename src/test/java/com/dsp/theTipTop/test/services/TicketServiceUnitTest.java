package com.dsp.theTipTop.test.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsp.theTipTop.entities.Ticket;
import com.dsp.theTipTop.repositories.TicketRepository;
import com.dsp.theTipTop.services.TicketService;


@TestPropertySource(locations = "/application-local.properties") //for local test
@SpringBootTest(webEnvironment = WebEnvironment.NONE) 
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class TicketServiceUnitTest {


	@Mock
	private TicketRepository ticketRepository;
	
	@InjectMocks
	private TicketService ticketService;
	

	
	
	@Test
	void testAddTicket() {
		Ticket aMockTicket  = new Ticket();
		aMockTicket.setTicketId((long) 456);
		aMockTicket.setName("ticket name");
		aMockTicket.setHadTheGift(false);
		
		when(ticketRepository.save(any(Ticket.class))).thenReturn(aMockTicket);
		
		ResponseEntity<String> savedTicketId = ticketService.save(aMockTicket);
		assertNotNull(savedTicketId);
		assertEquals("456",savedTicketId.getBody());
	}

}
