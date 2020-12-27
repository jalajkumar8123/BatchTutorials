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



@Service
public class BatchServiceImpl implements BatchService
{
	
	//List<Batch> batchlist;
		
	@Autowired
	private BatchDao bdao;
	@Autowired
	private WeekDao wdao;
	@Autowired
	private BatchWeekDao bwdao;
	@Autowired
	private WeekDateDao wbdao;
	@Autowired
	private DateDao ddao;
			
		public	BatchServiceImpl()

			{
			/*	this.batchlist=new ArrayList<>();
				batchlist.add(new Batch(001, 3, 100, "clientShortName", "batchName", "type", "status", "technology", "mentors", "startdate", "enddate"));
				batchlist.add(new Batch(002, 3, 100, "clientShortName", "batchName", "type", "status", "technology", "mentors", "startdate", "enddate"));
				batchlist.add(new Batch(003, 3, 100, "clientShortName", "batchName", "type", "status", "technology", "mentors", "startdate", "enddate"));
			*/
			
			}
	@Override
	public List<Batch> getbatchdetails() {
		// TODO Auto-generated method stub
		return (List<Batch>)bdao.findAll();
	}
	
	@Override
	public Batch addbatch(Batch batch) {
		// TODO Auto-generated method stub
		//batchlist.add(batch);
		
		return bdao.save(batch);
	}
	@Override
	public Batch update(Batch batch) {
		// TODO Auto-generated method stub
		 return bdao.save(batch);
	}
	@Override
	public void delete(int batchid) {
		// TODO Auto-generated method stub
		bdao.deleteById(batchid);
	}
	
	
	
	@Override
	public List<BatchWeek> getbatchweekdetail(int batchid) {
		List<BatchWeek> batchweek=  bwdao.findAllBybatchId(batchid);
		return batchweek;
	}
	@Override
	public Batch getbatchdetail(int batchid) {
		// TODO Auto-generated method stub
		return bdao.findById(batchid).orElse(new Batch());
	}
	@Override
	public Week addweek(Week week) {
		// TODO Auto-generated method stub
		return wdao.save(week);
	}
	@Override
	public List<Dates> getdatedetails() {
		// TODO Auto-generated method stub
		return (List<Dates>) ddao.findAll();
	}
	@Override
	public Week getweekdetail(int weekid) {
		// TODO Auto-generated method stub
		return wdao.findById(weekid).orElse(new Week());
	}
	@Override
	public List<WeekDate> getweekdatedetail(int weekid) {
		// TODO Auto-generated method stub
		List<WeekDate> weekDate=  wbdao.findAllByweekId(weekid);
		
		return weekDate;
	}
}