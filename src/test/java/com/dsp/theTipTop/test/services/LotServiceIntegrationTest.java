package com.dsp.theTipTop.test.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsp.theTipTop.entities.Lot;
import com.dsp.theTipTop.services.LotService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE) 
class LotServiceIntegrationTest {

	@Autowired
	private LotService lotService;
	
	
	@Test
	void testAddLot() {
		Lot lot  = new Lot();
		lot.setId((long) 123);
		lot.setName("Lot de test 1");
		lot.setPrice(999.12);
		lot.setDescription("ceci est pour les tests");
		
		
		ResponseEntity<String> savedLotId = lotService.save(lot);
		assertNotNull(savedLotId);
		assertEquals("123",savedLotId.getBody());
	}

}
