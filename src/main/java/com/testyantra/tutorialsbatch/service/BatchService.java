package com.testyantra.tutorialsbatch.service;

/** This Interface is for make Generalization of the Services 
 * 
 * @author jalaj Kumar 
 * @see BatchServiceImpl
 * */

import java.util.List;

import com.testyantra.tutorialsbatch.entities.Batch;
import com.testyantra.tutorialsbatch.entities.BatchWeek;
import com.testyantra.tutorialsbatch.entities.Dates;
import com.testyantra.tutorialsbatch.entities.Week;
import com.testyantra.tutorialsbatch.entities.WeekDate;

public interface BatchService {

	/**
	 * Returns the List of the Bath Class Object which is fetched from the Database
	 */
	public List<Batch> getBatchDetails();

	/** Returns the Bath Class Object which is fetched from the Database */
	public Batch getBatchDetail(int batchid);

	/**
	 * Returns the List of the Mapped Class of BathWeek Class Object which is
	 * fetched from the Database
	 */
	public List<BatchWeek> getBatchWeekDetail(int batchId);

	/**
	 * Returns the List of the Mapped Class of WeekDate Class Object which is
	 * fetched from the Database
	 */
	public List<WeekDate> getWeekDateDetail(int weekId);

	/** Returns the Bath Class Object which is Saved or stored to the Database */
	public Batch addBatch(Batch batch);

	/** Returns the Bath Class Object which is Updated in the Database */
	public Batch update(Batch batch);

	/** Returns nothing to delete the Batch entity Database */
	public void delete(int batchId);

	/** Returns the Week Class Object which is Saved or stored to the Database */
	public Week addWeek(Week week);

	/**
	 * Returns the List of the Dates Class Object which is fetched from the Database
	 */
	public List<Dates> getDateDetails();

	/** Returns the Week Class Object which is fetched from the Database */
	public Week getWeekDetail(int weekId);
}
