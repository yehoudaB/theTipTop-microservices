package com.dsp.theTipTop.test.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsp.theTipTop.entities.User;
import com.dsp.theTipTop.repositories.UserRepository;
import com.dsp.theTipTop.services.UserService;

// DEMARRER WAMP EN LOCAL
//@TestPropertySource(locations = "/application-local.properties") //for local test
@SpringBootTest(webEnvironment = WebEnvironment.NONE) 
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class UserServiceUnitTest {


	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	

	
	
	@Test
	void testAddUser() {
		User aMockUser  = new User();
		aMockUser.setId((long) 456);
		aMockUser.setFirstName("marc");
		aMockUser.setLastName("zukenberg");
		aMockUser.setEmail("uneadresse@gmail.com");
		
		when(userRepository.save(any(User.class))).thenReturn(aMockUser);
		
		ResponseEntity<String> savedUserId = userService.save(aMockUser);
		assertNotNull(savedUserId);
		assertEquals("456",savedUserId.getBody());
	}

}
