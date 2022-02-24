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

import com.dsp.theTipTop.entities.Lot;
import com.dsp.theTipTop.repositories.LotRepository;
import com.dsp.theTipTop.services.LotService;


@TestPropertySource(locations = "/application-local.properties") //for local test
@SpringBootTest(webEnvironment = WebEnvironment.NONE) 
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class LotServiceUnitTest {


	@Mock
	private LotRepository lotRepository;
	
	@InjectMocks
	private LotService lotService;
	

	
	
	@Test
	void testAddLot() {
		Lot aMockLot  = new Lot();
		aMockLot.setId((long) 456);
		aMockLot.setName("Lot de test 1");
		aMockLot.setPrice(999.12);
		aMockLot.setDescription("ceci est pour les tests");
		
		when(lotRepository.save(any(Lot.class))).thenReturn(aMockLot);
		
		ResponseEntity<String> savedLotId = lotService.save(aMockLot);
		assertNotNull(savedLotId);
		assertEquals("456",savedLotId.getBody());
	}

}
