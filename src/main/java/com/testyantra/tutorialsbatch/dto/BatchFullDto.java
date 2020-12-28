package com.testyantra.tutorialsbatch.dto;


import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class BatchFullDto 
{
	private int id;
	private int trainingdays,totalcandidates;
	private String clientShortName,batchName,type,status,technology,mentors;
	private String startdate,enddate;
	
	private List<WeekDto> weekdto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrainingdays() {
		return trainingdays;
	}

	public void setTrainingdays(int trainingdays) {
		this.trainingdays = trainingdays;
	}

	public int getTotalcandidates() {
		return totalcandidates;
	}

	public void setTotalcandidates(int totalcandidates) {
		this.totalcandidates = totalcandidates;
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

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public List<WeekDto> getWeekdto() {
		return weekdto;
	}

	public void setWeekdto(List<WeekDto> weekdto) {
		this.weekdto = weekdto;
	}

		
	
	

}
