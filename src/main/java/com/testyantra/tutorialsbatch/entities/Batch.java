package com.testyantra.tutorialsbatch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int trainingdays,totalcandidates;
	private String clientShortName,batchName,type,status,technology,mentors;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	String startdate,enddate;
	
	
	
	public Batch() {}
	
	public Batch(int id, int trainingdays, int totalcandidates, String clientShortName, String batchName, String type,
			String status, String technology, String mentors, String startdate, String enddate) {
		super();
		this.id = id;
		this.trainingdays = trainingdays;
		this.totalcandidates = totalcandidates;
		this.clientShortName = clientShortName;
		this.batchName = batchName;
		this.type = type;
		this.status = status;
		this.technology = technology;
		this.mentors = mentors;
		this.startdate = startdate;
		this.enddate = enddate;
		
		
		
		
		
	}
	
	
	
	
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

	@Override
	public String toString() {
		return "Batch [id=" + id + ", trainingdays=" + trainingdays + ", totalcandidates=" + totalcandidates
				+ ", clientShortName=" + clientShortName + ", batchName=" + batchName + ", type=" + type + ", status="
				+ status + ", technology=" + technology + ", mentors=" + mentors + ", startdate=" + startdate
				+ ", enddate=" + enddate +  "]";
	}
	

}
