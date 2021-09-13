package com.dsp.theTipTop.test.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsp.theTipTop.entities.User;
import com.dsp.theTipTop.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE) 
//@TestPropertySource(locations = "/application-local.properties") //for local test
class UserServiceIntegrationTest {

	@Autowired
	private UserService userService;
	
	
	@Test
	void testAddUser() {
		User user  = new User();
		Timestamp ts = Timestamp.from(Instant.now());
		user.setFirstName("Charle");
		user.setLastName("De Gaulle");
		user.setEmail("degaulle122"+ts.toString()+"@gmail.com");
		user.setCanEmailMe(true);
		user.setHadHisGift(false);
		
		
		
		ResponseEntity<String> savedUserId = userService.save(user);
		assertNotNull(savedUserId);
		assertThat(Integer.parseInt(savedUserId.getBody())).isBetween(1, 99999);
	}

}
