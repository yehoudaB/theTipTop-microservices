package com.dsp.theTipTop.test;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsp.theTipTop.TheTipTopApplication;


@TestPropertySource(locations = "/application-local.properties")
@SpringBootTest(classes = TheTipTopApplication.class)
@RunWith(SpringRunner.class)
class TheTipTopApplicationTests {

	@Test
	void contextLoads() {
		assertFalse(true);
	}
	
	

}
