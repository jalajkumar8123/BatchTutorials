package com.testyantra.tutorialsbatch.service;

import java.util.List;

import com.testyantra.tutorialsbatch.entities.Batch;
import com.testyantra.tutorialsbatch.entities.BatchWeek;
import com.testyantra.tutorialsbatch.entities.Dates;
import com.testyantra.tutorialsbatch.entities.Week;
import com.testyantra.tutorialsbatch.entities.WeekDate;

public interface BatchService {

	public List<Batch> getBatchDetails();

	public Batch getBatchDetail(int batchid);

	public List<BatchWeek> getBatchWeekDetail(int batchid);

	public List<WeekDate> getWeekDateDetail(int weekid);

	public Batch addBatch(Batch batch);

	public Batch update(Batch batch);

	public void delete(int batchid);

	public Week addWeek(Week week);

	public List<Dates> getDateDetails();

	public Week getWeekDetail(int weekid);
}
