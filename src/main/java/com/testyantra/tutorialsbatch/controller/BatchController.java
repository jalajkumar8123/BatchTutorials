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

/**
 * This is Class is Controller Class for CRUD operation of this project Which is
 * responding to the requests from the clients or front end Which is build using
 * spring boot, rest, maven,java 8
 * 
 * @author jalaj Kumar
 */

@RestController
public class BatchController {

	/** To Provide Service for Batch Object */
	@Autowired
	private BatchService batchService;

	/** To Provide Responses for the Requests */
	@Autowired
	private ResponceDto responce;

	/** To Store the BatchDto Object to process Response */
	@Autowired
	private BatchDto batchDto;

	/** To Store the WeekDto Object to process Response */
	@Autowired
	private WeekDto weekDto;

	/** To Store the BatchFullDto Object to process Response */
	@Autowired
	BatchFullDto batchFullDetail;

	/**
	 * Returns the all Batch Entity which is present the Database as a list of Batch
	 * Object Request as get property
	 */
	@GetMapping("/batchdetails")
	public ResponceDto getBatchDetails() {
		try {
			responce.setData(this.batchService.getBatchDetails());
			responce.setError(false);
			return responce;
		} catch (Exception e) {
			responce.setError(true);
		}
		return responce;
	}

	/**
	 * Returns the Single Batch Entity which is Satisfy the Id provided as the
	 * Request as get property
	 */
	@GetMapping("/batchdetails/{batchId}")
	public ResponceDto getBatchDetailById(@PathVariable String batchId) {
		try {
			responce.setData(this.batchService.getBatchDetail(Integer.parseInt(batchId)));
			responce.setError(false);
			return responce;
		} catch (Exception e) {
			responce.setError(true);
		}
		return responce;

	}

	/**
	 * Returns the Single batch Entity which is Satisfy the Id and list of weeks
	 * which is mapped to batch Id and request as get property
	 */
	@GetMapping("/batchdetails/{batchId}/weeks")
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
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
		}
		return responce;
	}

	/**
	 * Returns the Single batch Entity which is Satisfy the Id and list of weeks
	 * which is mapped to batch Id and for single week a list of Dates objects which
	 * is mapped to week ID . This method returns Fully qualified data and sub data
	 * as a request as get property
	 */
	@GetMapping("/batchdetails/{batchId}/weeks/dates")
	public ResponceDto getFullDetails(@PathVariable String batchId) {

		try {
			Batch batch = batchService.getBatchDetail(Integer.parseInt(batchId));

			batchFullDetail.setId(batch.getId());
			batchFullDetail.setBatchName(batch.getBatchName());
			batchFullDetail.setClientShortName(batch.getClientShortName());
			batchFullDetail.setEndDate(batch.getEndDate());
			batchFullDetail.setMentors(batch.getMentors());
			batchFullDetail.setStartDate(batch.getStartDate());
			batchFullDetail.setStatus(batch.getStatus());
			batchFullDetail.setTechnology(batch.getTechnology());
			batchFullDetail.setTotalCandidates(batch.getTotalCandidates());
			batchFullDetail.setTrainingDays(batch.getTrainingDays());
			batchFullDetail.setType(batch.getType());

			List<BatchWeek> batchWeekList = batchService.getBatchWeekDetail(Integer.parseInt(batchId));
			List<WeekDto> weekDtoList = new ArrayList<>();

			for (BatchWeek batchWeek : batchWeekList) {

				System.err.println("Batch week " + batchWeek.getId() + " batch id " + batchWeek.getBatch().getId()
						+ " week id " + batchWeek.getWeek().getId());
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
			batchFullDetail.setWeekdto(weekDtoList);
			responce.setData(batchFullDetail);
			responce.setError(false);
			return responce;
		} catch (Exception e) {
			// TODO: handle exception
			responce.setData(null);
			responce.setError(true);
		}
		return responce;
	}

	/**
	 * Returns the Single Week Entity which is Satisfy the Id provided as the
	 * Request as get property
	 */
	@GetMapping("/weekdetails/{weekId}")
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

			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
			return responce;
		}
	}

	/**
	 * Returns the Single Batch Entity which is taken data from request body to
	 * store in the database Request as Post property
	 */
	@PostMapping("/batchdetails")
	public ResponceDto addBatchDetail(@RequestBody Batch batch) {

		try {
			responce.setData(this.batchService.addBatch(batch));
			responce.setError(false);
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
		}
		return responce;
	}

	/**
	 * Returns the Single Batch Entity which is taken data from request body to
	 * update in the database Request as Put property
	 */
	@PutMapping("/batchdetails")
	public ResponceDto update(@RequestBody Batch batch) {

		try {
			responce.setData(this.batchService.update(batch));
			responce.setError(false);
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
		}
		return responce;
	}

	/**
	 * Returns the Response as Deleted Successfully which is Deleted in the database
	 * Request as Delete property
	 */
	@DeleteMapping("/deletdetails/{batchId}")
	public ResponceDto delete(@PathVariable String batchId) {
		try {
			batchService.delete(Integer.parseInt(batchId));
			responce.setData("{ Deleted successfully }");
			responce.setError(false);
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
		}
		return responce;
	}

	/**
	 * Returns the Single Week Entity which is taken data from request body to store
	 * in the database Request as Post property
	 */
	@PostMapping("/weeks")
	public Week addFullDetail(@RequestBody Week week) {
		return this.batchService.addWeek(week);
	}

	/**
	 * Returns the all Dates Entity which is present the Database as a list of Dates
	 * Object Request as get property
	 */
	@GetMapping("/dates")
	public ResponceDto getDateDetails() {
		try {
			responce.setData(this.batchService.getDateDetails());
			responce.setError(false);
			return responce;
		} catch (Exception e) {
			responce.setData(null);
			responce.setError(true);
			return responce;
		}
	}

}
