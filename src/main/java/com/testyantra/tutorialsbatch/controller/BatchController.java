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

	/*
	 * @GetMapping("/batchdetails/{batchid}/weeks/dates") public BatchFullDto
	 * getfulldetails(@PathVariable String batchid) { BatchFullDto fulldetail = new
	 * BatchFullDto(); Batch b = bservice.getbatchdetail(Integer.parseInt(batchid));
	 * fulldetail.setId(b.getId()); fulldetail.setBatchName(b.getBatchName());
	 * fulldetail.setClientShortName(b.getClientShortName());
	 * fulldetail.setEnddate(b.getEnddate()); fulldetail.setMentors(b.getMentors());
	 * fulldetail.setStartdate(b.getStartdate());
	 * fulldetail.setStatus(b.getStatus());
	 * fulldetail.setTechnology(b.getTechnology());
	 * fulldetail.setTotalcandidates(b.getTotalcandidates());
	 * fulldetail.setTrainingdays(b.getTrainingdays());
	 * fulldetail.setType(b.getType());
	 * 
	 * return null; }
	 */

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
