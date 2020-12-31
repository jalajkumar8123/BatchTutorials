package com.testyantra.tutorialsbatch;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Assertions;

import com.testyantra.tutorialsbatch.dao.BatchDao;
import com.testyantra.tutorialsbatch.dao.BatchWeekDao;
import com.testyantra.tutorialsbatch.dao.DateDao;
import com.testyantra.tutorialsbatch.dao.WeekDao;
import com.testyantra.tutorialsbatch.dao.WeekDateDao;
import com.testyantra.tutorialsbatch.entities.Batch;
import com.testyantra.tutorialsbatch.entities.BatchWeek;
import com.testyantra.tutorialsbatch.entities.Dates;
import com.testyantra.tutorialsbatch.entities.Week;
import com.testyantra.tutorialsbatch.entities.WeekDate;
import com.testyantra.tutorialsbatch.service.BatchService;

@SpringBootTest
class TutorialsbatchApplicationTests {

	/**
	 * Autowire in the service we want to test
	 */
	@Autowired
	private BatchService service;

	/**
	 * Create a mock implementation of the BatchRepository
	 */
	@MockBean
	private BatchDao repositoryBatch;

	/**
	 * Create a mock implementation of the BatchWeekRepository
	 */
	@MockBean
	private BatchWeekDao repositoryBatchWeek;

	/**
	 * Create a mock implementation of the WeekRepository
	 */
	@MockBean
	private WeekDao repositoryWeek;

	/**
	 * Create a mock implementation of the DateRepository
	 */
	@MockBean
	private DateDao repositoryDate;
	
	/**
	 * Create a mock implementation of the DateRepository
	 */
	@MockBean
	private WeekDateDao repositoryWeekDate;
	
	/**
	 * Testcase for FindById in return type Batch
	 */
	@Test
	void testGetBatchDetail() {
		Batch batch = new Batch();
		batch.setId(14);
		batch.setBatchName("batchName");
		batch.setClientShortName("clientShortName");
		batch.setEndDate("2020-05-01");
		doReturn(Optional.of(batch)).when(repositoryBatch).findById(14);
		Batch returnedBatch = service.getBatchDetail(14);

		Assertions.assertEquals(batch, returnedBatch, "Success");
	}

	/**
	 * Testcase for FindByAll in return type Batch
	 */
	@Test
	void testGetBatchDetails() {
		Batch batch = new Batch();
		batch.setId(14);
		batch.setBatchName("batchName");
		batch.setClientShortName("clientShortName");
		batch.setEndDate("2020-05-01");
		Batch batch1 = new Batch();
		batch.setId(15);
		batch1.setBatchName("batchName");
		batch1.setClientShortName("clientShortName");
		batch1.setEndDate("2020-05-01");
		doReturn(Arrays.asList(batch, batch1)).when(repositoryBatch).findAll();
		// Execute the service call
		List<Batch> batchList = service.getBatchDetails();

		Assertions.assertEquals(2, batchList.size(), "Success");
	}

	@Test
	void testAddBatch() {
		Batch batch = new Batch();
		batch.setId(14);
		batch.setBatchName("batchName");
		batch.setClientShortName("clientShortName");
		batch.setEndDate("2020-05-01");
		doReturn(batch).when(repositoryBatch).save(any());

		Batch batch1 = service.addBatch(batch);

		Assertions.assertEquals(batch, batch1, "Success");
	}

	@Test
	void testUpdate() {
		Batch batch = new Batch();
		batch.setId(14);
		batch.setBatchName("batchName");
		batch.setClientShortName("clientShortName");
		batch.setEndDate("2020-05-01");
		doReturn(batch).when(repositoryBatch).save(any());

		Batch batch1 = service.addBatch(batch);

		Assertions.assertEquals(batch, batch1, "Success");
	}

	@Test
	void testGetBatchWeekDetail() {
		Batch batch = new Batch();
		batch.setId(14);
		batch.setBatchName("batchName");
		batch.setClientShortName("clientShortName");
		batch.setEndDate("2020-05-01");
		BatchWeek batchWeek = new BatchWeek();
		batchWeek.setId(15);
		batchWeek.setBatch(batch);
		batchWeek.setWeek(new Week());
		Batch batch1 = new Batch();
		batch1.setId(15);
		batch1.setBatchName("batchName");
		batch1.setClientShortName("clientShortName");
		batch1.setEndDate("2020-05-01");
		BatchWeek batchWeek1 = new BatchWeek();
		batchWeek1.setId(15);
		batchWeek1.setBatch(batch);
		batchWeek1.setWeek(new Week());
		doReturn(Arrays.asList(batchWeek, batchWeek1)).when(repositoryBatchWeek).findAllBybatchId(15);

		List<BatchWeek> batchweek = service.getBatchWeekDetail(15);

		Assertions.assertEquals(2, batchweek.size(), "Success");
	}

	@Test
	void testAddWeek() {
		Week week = new Week();
		week.setId(20);
		week.setNoDays(7);
		week.setNoWeeks(1);
		week.setStartDate("2020-12-2");
		doReturn(week).when(repositoryWeek).save(any());

		Week weekreturned = service.addWeek(week);
		Assertions.assertEquals(week, weekreturned, "Success");
	}

	@Test
	void testGetDateDetails() {
		Dates date1 = new Dates();
		date1.setId(21);
		date1.setDate("2020-12-2");
		date1.setStatus("status ");
		Dates date2 = new Dates();
		date2.setId(21);
		date2.setDate("2020-11-2");
		date2.setStatus("status ");

		doReturn(Arrays.asList(date1, date2)).when(repositoryDate).findAll();
		List<Dates> dateList = service.getDateDetails();

		Assertions.assertEquals(2, dateList.size(), "Success");

	}
	
	@Test
	void testGetWeekDetail() {
		Week week = new Week();
		week.setId(20);
		week.setNoDays(7);
		week.setNoWeeks(1);
		week.setStartDate("2020-12-2");
		doReturn(Optional.of(week)).when(repositoryWeek).findById(20);
		
		Week weekReturned = service.getWeekDetail(20);
		Assertions.assertEquals(week, weekReturned,"Success");
	}
	
	@Test 
	void testGetWeekDateDetail() {
		WeekDate weekDate = new WeekDate();
		weekDate.setId(22);
		weekDate.setDate(new Dates());
		weekDate.setWeek(new Week());
		WeekDate weekDate1 = new WeekDate();
		weekDate1.setId(22);
		weekDate1.setDate(new Dates());
		weekDate1.setWeek(new Week());
		WeekDate weekDate2 = new WeekDate();
		weekDate2.setId(22);
		weekDate2.setDate(new Dates());
		weekDate2.setWeek(new Week());
		doReturn(Arrays.asList(weekDate,weekDate1,weekDate2)).when(repositoryWeekDate).findAllByweekId(22);
		
		List<WeekDate> weekdatlst = service.getWeekDateDetail(22);
		Assertions.assertEquals(3, weekdatlst.size(),"Success");
	}

}
