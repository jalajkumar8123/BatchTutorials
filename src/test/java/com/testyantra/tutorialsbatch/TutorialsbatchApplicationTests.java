package com.testyantra.tutorialsbatch;

import org.junit.jupiter.api.Test;
import  static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.testyantra.tutorialsbatch.controller.BatchController;
import com.testyantra.tutorialsbatch.dto.ResponceDto;

@SpringBootTest
class TutorialsbatchApplicationTests {

	@Test
	void contextLoads() {
		BatchController batchcontroller = new BatchController();
		ResponceDto actual = new ResponceDto();
		ResponceDto expected = batchcontroller.getBatchDetails();
		assertEquals(actual, expected);
		//System.out.println("First actual testing");
	}

}
