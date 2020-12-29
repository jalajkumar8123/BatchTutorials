package com.testyantra.tutorialsbatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.tutorialsbatch.dao.BatchDao;
import com.testyantra.tutorialsbatch.dao.DateDao;
import com.testyantra.tutorialsbatch.dao.WeekDao;
import com.testyantra.tutorialsbatch.dao.WeekDateDao;
import com.testyantra.tutorialsbatch.dao.BatchWeekDao;
import com.testyantra.tutorialsbatch.entities.Batch;
import com.testyantra.tutorialsbatch.entities.BatchWeek;
import com.testyantra.tutorialsbatch.entities.Dates;
import com.testyantra.tutorialsbatch.entities.Week;
import com.testyantra.tutorialsbatch.entities.WeekDate;

/**
 * This is an Implementation class of an BatchService interface to fetch the
 * entity details returns the Entity Objects
 * 
 * @author Jalaj kumar
 */

@Service
public class BatchServiceImpl implements BatchService {

	/** To Access the Batch Entity Object */
	@Autowired
	private BatchDao batchDao;

	/** To Access the Week Entity Object */
	@Autowired
	private WeekDao weekDao;

	/** To Access the BatchWeek Entity Object */
	@Autowired
	private BatchWeekDao batchWeekDao;

	/** To Access the WeekDate Entity Object */
	@Autowired
	private WeekDateDao weekDateDao;

	/** To Access the Date Entity Object */
	@Autowired
	private DateDao dateDao;

	public BatchServiceImpl() {

	}

	/**
	 * Returns the List of the Bath Class Object which is fetched from the Database
	 */
	@Override
	public List<Batch> getBatchDetails() {
		// TODO Auto-generated method stub
		return (List<Batch>) batchDao.findAll();
	}

	/** Returns the Bath Class Object which is Saved or stored to the Database */
	@Override
	public Batch addBatch(Batch batch) {
		// TODO Auto-generated method stub
		return batchDao.save(batch);
	}

	/** Returns the Bath Class Object which is Updated in the Database */
	@Override
	public Batch update(Batch batch) {
		// TODO Auto-generated method stub
		return batchDao.save(batch);
	}

	/** Returns nothing to delete the Batch entity Database */
	@Override
	public void delete(int batchId) {
		// TODO Auto-generated method stub
		batchDao.deleteById(batchId);
	}

	/**
	 * Returns the List of the Mapped Class of WeekDate Class Object which is
	 * fetched from the Database
	 */
	@Override
	public List<BatchWeek> getBatchWeekDetail(int batchId) {
		List<BatchWeek> batchWeek = batchWeekDao.findAllBybatchId(batchId);
		return batchWeek;
	}

	/** Returns the Bath Class Object which is fetched from the Database */
	@Override
	public Batch getBatchDetail(int batchId) {
		// TODO Auto-generated method stub
		return batchDao.findById(batchId).orElse(new Batch());
	}

	/** Returns the Week Class Object which is Saved or stored to the Database */
	@Override
	public Week addWeek(Week week) {
		// TODO Auto-generated method stub
		return weekDao.save(week);
	}

	/**
	 * Returns the List of the Dates Class Object which is fetched from the Database
	 */
	@Override
	public List<Dates> getDateDetails() {
		// TODO Auto-generated method stub
		return (List<Dates>) dateDao.findAll();
	}

	/** Returns the Week Class Object which is fetched from the Database */
	@Override
	public Week getWeekDetail(int weekId) {
		// TODO Auto-generated method stub
		return weekDao.findById(weekId).orElse(new Week());
	}

	/**
	 * Returns the List of the Mapped Class of WeekDate Class Object which is
	 * fetched from the Database
	 */
	@Override
	public List<WeekDate> getWeekDateDetail(int weekId) {
		// TODO Auto-generated method stub
		List<WeekDate> weekDate = weekDateDao.findAllByweekId(weekId);

		return weekDate;
	}
}