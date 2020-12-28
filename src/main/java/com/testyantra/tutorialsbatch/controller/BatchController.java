package com.testyantra.tutorialsbatch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.tutorialsbatch.dto.BatchDto;
import com.testyantra.tutorialsbatch.dto.BatchFullDto;
import com.testyantra.tutorialsbatch.dto.ResponceDto;
import com.testyantra.tutorialsbatch.dto.WeekDto;
import com.testyantra.tutorialsbatch.entities.Batch;
import com.testyantra.tutorialsbatch.entities.BatchWeek;
import com.testyantra.tutorialsbatch.entities.Dates;
import com.testyantra.tutorialsbatch.entities.Week;
import com.testyantra.tutorialsbatch.entities.WeekDate;
import com.testyantra.tutorialsbatch.service.BatchService;



@RestController
public class BatchController {

	@Autowired
	private BatchService bservice;
	@Autowired
	private ResponceDto responce;
	@Autowired
	private BatchDto batchdto;
	@Autowired
	private WeekDto weekdto;
	@Autowired
	BatchFullDto fulldetail ;
	
	
	@GetMapping("/batchdetails")
	public ResponceDto getbatchdetails() {
		try {
		responce.setData(this.bservice.getbatchdetails());
		responce.setMessege("");responce.setError(false);return responce;
		}catch(Exception e) {responce.setError(true);responce.setMessege(e.getMessage());}
		return responce;
	}

	@GetMapping("/batchdetails/{batchid}")
	public ResponceDto getbatchdetail(@PathVariable String batchid) {
		try {
		responce.setData(this.bservice.getbatchdetail(Integer.parseInt(batchid)));
		responce.setError(false);responce.setMessege("");return responce;
		}catch(Exception e) {responce.setError(true);responce.setMessege(e.getMessage());}
		return responce;

	}

	@GetMapping("/batchdetails/{batchid}/weeks")
	public ResponceDto getbatchweekdetails(@PathVariable String batchid) {
		try{
		batchdto = new BatchDto();
		Batch b = bservice.getbatchdetail(Integer.parseInt(batchid));
		batchdto.setId(b.getId());
		batchdto.setBatchName(b.getBatchName());
		batchdto.setClientShortName(b.getClientShortName());
		batchdto.setEnddate(b.getEnddate());
		batchdto.setMentors(b.getMentors());
		batchdto.setStartdate(b.getStartdate());
		batchdto.setStatus(b.getStatus());
		batchdto.setTechnology(b.getTechnology());
		batchdto.setTotalcandidates(b.getTotalcandidates());
		batchdto.setTrainingdays(b.getTrainingdays());
		batchdto.setType(b.getType());
		System.err.print(b.toString());
		List<BatchWeek> batchweeks = this.bservice.getbatchweekdetail(Integer.parseInt(batchid));
		List<Week> weeks = new ArrayList<>();
		for (BatchWeek batchweek : batchweeks) {
			Week week = batchweek.getWeek();
			System.err.print("week details " + week.toString());
			weeks.add(week);
		}
		batchdto.setWeeks(weeks);
		responce.setError(false);
		responce.setData(batchdto);
		responce.setMessege("");
		return responce;
		}
		catch(Exception e)
		{
			responce.setData(null);
			responce.setError(true);
			responce.setMessege(e.toString());
		}
		return responce;
	}

	
	  @GetMapping("/batchdetails/{batchid}/weeks/dates") 
	  public ResponceDto getfulldetails(@PathVariable String batchid) { 
		   
		  try {
		  Batch batch =bservice.getbatchdetail(Integer.parseInt(batchid));
		  fulldetail.setId(batch.getId()); fulldetail.setBatchName(batch.getBatchName());
		  fulldetail.setClientShortName(batch.getClientShortName());
		  fulldetail.setEnddate(batch.getEnddate()); fulldetail.setMentors(batch.getMentors());
		  fulldetail.setStartdate(batch.getStartdate());
		  fulldetail.setStatus(batch.getStatus());
		  fulldetail.setTechnology(batch.getTechnology());
		  fulldetail.setTotalcandidates(batch.getTotalcandidates());
		  fulldetail.setTrainingdays(batch.getTrainingdays());
		  fulldetail.setType(batch.getType());
	  
	  List<BatchWeek> batchweeklist = bservice.getbatchweekdetail(Integer.parseInt(batchid));
	  List<WeekDto> weekdtolist = new ArrayList<>();
	  
	  for(BatchWeek batchweek :batchweeklist) {
		  
		  System.err.println("Batch week "+ batchweek.getId()+" batch id "+batchweek.getBatch().getId()+" week id "+batchweek.getWeek().getWeekid());
		  
		  //int weekid = batchweek.getWeek().getWeekid();
		 // Week week = batchweek.getWeek();
		  WeekDto weekdtolp=new WeekDto(); 
		  weekdtolp.setId(batchweek.getWeek().getWeekid()); 
		  weekdtolp.setNodays(batchweek.getWeek().getNodays());
		  weekdtolp.setEnddate(batchweek.getWeek().getEnddate());
		  weekdtolp.setNoweeks(batchweek.getWeek().getNoweeks());
		  weekdtolp.setStartdate(batchweek.getWeek().getStartdate());
		 weekdtolist.add(weekdtolp);
	  	}
	  for(WeekDto weekdto : weekdtolist) {
	  List<WeekDate> weekdates = this.bservice.getweekdatedetail(weekdto.getId());
	  List<Dates> dates = new ArrayList<>();
		for (WeekDate weekdate : weekdates) {
			Dates date = weekdate.getDate();
			dates.add(date);
		}
		weekdto.setDates(dates);
	  }
	  
	  	   //weekdtolist.add(weekdto);
	  	   fulldetail.setWeekdto(weekdtolist);
		   responce.setData(fulldetail);
		   responce.setError(false);
		   responce.setMessege("");
		   return responce;
		  }
		  catch (Exception e) {
			// TODO: handle exception
			  responce.setData(null);responce.setError(true);responce.setMessege(e.getMessage());
		}
		return responce;
	}
	 

	@GetMapping("/weekdetails/{weekid}")
	public ResponceDto getweekdatedetails(@PathVariable String weekid) {
		try {
		
		Week w = bservice.getweekdetail(Integer.parseInt(weekid));
		weekdto.setId(w.getWeekid());
		weekdto.setEnddate(w.getEnddate());
		weekdto.setNodays(w.getNodays());
		weekdto.setNoweeks(w.getNoweeks());
		weekdto.setStartdate(w.getStartdate());
		List<WeekDate> weekdates = this.bservice.getweekdatedetail(Integer.parseInt(weekid));
		List<Dates> dates = new ArrayList<>();
		for (WeekDate weekdate : weekdates) {
			Dates date = weekdate.getDate();
			dates.add(date);
		}
		weekdto.setDates(dates);
		responce.setData(weekdto);responce.setError(false);responce.setMessege("");
		
		return responce;
		}catch(Exception  e) {responce.setData(null);responce.setError(true);responce.setMessege(e.getMessage());
		return responce;
		}
	}

	@PostMapping("/batchdetails")
	public ResponceDto addbatchdetail(@RequestBody Batch batch) {
		try {
			responce.setData(this.bservice.addbatch(batch));
			responce.setError(false);responce.setMessege("");return responce;
			}catch(Exception e) {responce.setData(null);responce.setError(true);responce.setMessege(e.getMessage());}
			return responce;
	}

	@PutMapping("/batchdetails")
	public ResponceDto update(@RequestBody Batch batch) {
		try {
			responce.setData(this.bservice.update(batch));
			responce.setError(false);responce.setMessege("");return responce;
			}catch(Exception e) {responce.setData(null);responce.setError(true);responce.setMessege(e.getMessage());}
			return responce;
	}

	@DeleteMapping("/deletdetails/{batchid}")
	public ResponceDto delete(@PathVariable String batchid) {
		try{
			bservice.delete(Integer.parseInt(batchid));
			responce.setData("{ Deleted successfully }");
			responce.setError(false);responce.setMessege("");
			return responce;
		}catch(Exception e) {responce.setData(null);responce.setError(true);responce.setMessege(e.getMessage());}
		return responce;
	}

	@PostMapping("/weeks")
	public Week addfulldetail(@RequestBody Week week) {
		return this.bservice.addweek(week);
	}

	@GetMapping("/dates")
	public ResponceDto getdatedetails() {
		try {
			responce.setData(this.bservice.getdatedetails());
			responce.setError(false);responce.setMessege("");
		return responce;
		}catch(Exception e) {responce.setData(null);responce.setError(true);responce.setMessege(e.getMessage());
		return responce;
	}
	}

}
