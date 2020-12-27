package com.testyantra.tutorialsbatch.service;

import java.util.List;

import com.testyantra.tutorialsbatch.entities.Batch;
import com.testyantra.tutorialsbatch.entities.BatchWeek;
import com.testyantra.tutorialsbatch.entities.Dates;
import com.testyantra.tutorialsbatch.entities.Week;
import com.testyantra.tutorialsbatch.entities.WeekDate;



public interface BatchService {

	public List<Batch> getbatchdetails();
	public Batch getbatchdetail(int batchid);
	public List<BatchWeek> getbatchweekdetail(int batchid);
	public List<WeekDate> getweekdatedetail(int weekid);
	public Batch addbatch(Batch batch);
	public Batch update(Batch batch);
	public void delete(int batchid);
	public Week addweek(Week week);
	public List<Dates> getdatedetails();
	public Week getweekdetail(int weekid);
}
