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
	private BatchService batchService;
	@Autowired
	private ResponceDto responce;
	@Autowired
	private BatchDto batchDto;
	@Autowired
	private WeekDto weekDto;
	@Autowired
	BatchFullDto fullDetail;

	@GetMapping("/batchdetails")
	public ResponceDto getBatchDetails() {
		try {
			responce.setData(this.batchService.getBatchDetails());
			responce.setMessege("");
			responce.setError(false);
			return responce;
		} catch (Exception e) {
			responce.setError(true);
			responce.setMessege(e.getMessage());
		}
		return responce;
	}

	@GetMapping("/batchdetails/{batchid}")
	public ResponceDto getBatchDetailById(@PathVariable String batchId) {
		try {
			responce.setData(this.batchService.getBatchDetail(Integer.parseInt(batchId)));
			responce.setError(false);
			responce.setMessege("");
			return responce;
		} catch (Exception e) {
			responce.setError(true);
			responce.setMessege(e.getMessage());
		}
		return responce;

	}

	@GetMapping("/batchdetails/{batchid}/weeks")
	public ResponceDto getBatchWeekDetails(@PathVariable String batchId) {
		
		try {
			batchDto = new BatchDto();
			Batch b = batchService.getBatchDetail(Integer.parseInt(batchId));
			
			batchDto.setId(b.getId());
			batchDto.setBatchName(b.getBatchName());
			batchDto.setClientShortName(b.getClientShortName());
			batchDto.setEndDate(b.getEndDate());
			batchDto.setMentors(b.getMentors());
			batchDto.setStartDate(b.getStartDate());
			batchDto.setStatus(b.getStatus());
			batchDto.setTechnology(b.getTechnology());
			batchDto.setTotalCandidates(b.getTotalCandidates());
			batchDto.setTrainingDays(b.getTrainingDays());
			batchDto.setType(b.getType());
			System.err.print(b.toString());
			List<BatchWeek> batchWeeks = this.batchService.getBatchWeekDetail(Integer.parseInt(batchId));
			List<Week> weeks = new ArrayList<>();
			for (BatchWeek batchWeek : batchWeeks) {
				Week week = batchWeek.getWeek();
				System.err.print("week details " + week.toString());
				weeks.add(week);
			}
			batchDto.setWeeks(weeks);
			responce.setError(false);
			responce.setData(batchDto);
			responce.setMessege("");
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
			responce.setMessege(e.toString());
		}
		return responce;
	}

	@GetMapping("/batchdetails/{batchid}/weeks/dates")
	public ResponceDto getFullDetails(@PathVariable String batchId) {

		try {
			Batch batch = batchService.getBatchDetail(Integer.parseInt(batchId));
			
			fullDetail.setId(batch.getId());
			fullDetail.setBatchName(batch.getBatchName());
			fullDetail.setClientShortName(batch.getClientShortName());
			fullDetail.setEndDate(batch.getEndDate());
			fullDetail.setMentors(batch.getMentors());
			fullDetail.setStartDate(batch.getStartDate());
			fullDetail.setStatus(batch.getStatus());
			fullDetail.setTechnology(batch.getTechnology());
			fullDetail.setTotalCandidates(batch.getTotalCandidates());
			fullDetail.setTrainingDays(batch.getTrainingDays());
			fullDetail.setType(batch.getType());

			List<BatchWeek> batchWeekList = batchService.getBatchWeekDetail(Integer.parseInt(batchId));
			List<WeekDto> weekDtoList = new ArrayList<>();

			for (BatchWeek batchWeek : batchWeekList) {

				System.err.println("Batch week " + batchWeek.getId() + " batch id " + batchWeek.getBatch().getId()
						+ " week id " + batchWeek.getWeek().getId());

				// int weekid = batchweek.getWeek().getWeekid();
				// Week week = batchweek.getWeek();
				WeekDto weekDtoLp = new WeekDto();
				weekDtoLp.setId(batchWeek.getWeek().getId());
				weekDtoLp.setNoDays(batchWeek.getWeek().getNoDays());
				weekDtoLp.setEndDate(batchWeek.getWeek().getEndDate());
				weekDtoLp.setNoWeeks(batchWeek.getWeek().getNoWeeks());
				weekDtoLp.setStartDate(batchWeek.getWeek().getStartDate());
				weekDtoList.add(weekDtoLp);
			}
			for (WeekDto weekDto : weekDtoList) {
				List<WeekDate> weekDates = this.batchService.getWeekDateDetail(weekDto.getId());
				List<Dates> dates = new ArrayList<>();
				for (WeekDate weekDate : weekDates) {
					Dates date = weekDate.getDate();
					dates.add(date);
				}
				weekDto.setDates(dates);
			}

			// weekdtolist.add(weekdto);
			fullDetail.setWeekdto(weekDtoList);
			responce.setData(fullDetail);
			responce.setError(false);
			responce.setMessege("");
			return responce;
		} catch (Exception e) {
			// TODO: handle exception
			responce.setData(null);
			responce.setError(true);
			responce.setMessege(e.getMessage());
		}
		return responce;
	}

	@GetMapping("/weekdetails/{weekid}")
	public ResponceDto getWeekDateDetails(@PathVariable String weekId) {
		
		try {

			Week week = batchService.getWeekDetail(Integer.parseInt(weekId));
			weekDto.setId(week.getId());
			weekDto.setEndDate(week.getEndDate());
			weekDto.setNoDays(week.getNoDays());
			weekDto.setNoWeeks(week.getNoWeeks());
			weekDto.setStartDate(week.getStartDate());
			List<WeekDate> weekdates = this.batchService.getWeekDateDetail(Integer.parseInt(weekId));
			List<Dates> dates = new ArrayList<>();
			for (WeekDate weekdate : weekdates) {
				Dates date = weekdate.getDate();
				dates.add(date);
			}
			weekDto.setDates(dates);
			responce.setData(weekDto);
			responce.setError(false);
			responce.setMessege("");

			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
			responce.setMessege(e.getMessage());
			return responce;
		}
	}

	@PostMapping("/batchdetails")
	public ResponceDto addBatchDetail(@RequestBody Batch batch) {
		
		try {
			responce.setData(this.batchService.addBatch(batch));
			responce.setError(false);
			responce.setMessege("");
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
			responce.setMessege(e.getMessage());
		}
		return responce;
	}

	@PutMapping("/batchdetails")
	public ResponceDto update(@RequestBody Batch batch) {
		
		try {
			responce.setData(this.batchService.update(batch));
			responce.setError(false);
			responce.setMessege("");
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
			responce.setMessege(e.getMessage());
		}
		return responce;
	}

	@DeleteMapping("/deletdetails/{batchid}")
	public ResponceDto delete(@PathVariable String batchid) {
		try {
			batchService.delete(Integer.parseInt(batchid));
			responce.setData("{ Deleted successfully }");
			responce.setError(false);
			responce.setMessege("");
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
			responce.setMessege(e.getMessage());
		}
		return responce;
	}

	@PostMapping("/weeks")
	public Week addFullDetail(@RequestBody Week week) {
		return this.batchService.addWeek(week);
	}

	@GetMapping("/dates")
	public ResponceDto getDateDetails() {
		try {
			responce.setData(this.batchService.getDateDetails());
			responce.setError(false);
			responce.setMessege("");
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
			responce.setMessege(e.getMessage());
			return responce;
		}
	}

}
