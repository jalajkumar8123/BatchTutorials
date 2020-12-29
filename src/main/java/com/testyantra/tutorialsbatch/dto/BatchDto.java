package com.testyantra.tutorialsbatch.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.testyantra.tutorialsbatch.entities.Week;

/**
 * This class is Data Transfer Object Class is having the Members same as Batch
 * class and extra added member is Week class lists and returns the BatchDto
 * objects as response body. The main purpose of this is class is for Customized
 * response body
 * 
 * @author Jalaj Kumar
 */

@Component
public class BatchDto {

	/**
	 * These members are same as Batch class members and added one extra member is
	 * List of Week object
	 */
	private int id;
	private int trainingDays;
	private int totalCandidates;
	private String clientShortName;
	private String batchName;
	private String type;
	private String status;
	private String technology;
	private String mentors;
	private String startDate;
	private String endDate;

	private List<Week> weeks;

	/** getters and setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrainingDays() {
		return trainingDays;
	}

	public void setTrainingDays(int trainingDays) {
		this.trainingDays = trainingDays;
	}

	public int getTotalCandidates() {
		return totalCandidates;
	}

	public void setTotalCandidates(int totalCandidates) {
		this.totalCandidates = totalCandidates;
	}

	public String getClientShortName() {
		return clientShortName;
	}

	public void setClientShortName(String clientShortName) {
		this.clientShortName = clientShortName;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getMentors() {
		return mentors;
	}

	public void setMentors(String mentors) {
		this.mentors = mentors;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Week> getWeeks() {
		return weeks;
	}

	public void setWeeks(List<Week> weeks) {
		this.weeks = weeks;
	}

}
