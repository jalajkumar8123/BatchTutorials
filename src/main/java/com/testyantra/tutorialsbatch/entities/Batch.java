package com.testyantra.tutorialsbatch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**This class is Entity class to store the Batch details which is having some members 
 * @author jalaj Kumar 
 * 
 * */

@Entity
public class Batch {
	/**
	 * this is private key for this entity class name is ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/**
	 * this is member of this class to store the number of days are there in this
	 * batch
	 */
	private int trainingDays;
	/**
	 * this is member of the class to store the number of candidates are there in
	 * this batch
	 */
	private int totalCandidates;
	/** To store the Short name of the candidate */
	private String clientShortName;
	/** To store the Batch name */
	private String batchName;
	/** To store the Particular type of the Batch */
	private String type;
	/** To store the Status of the Batch */
	private String status;
	/** To store the Technology which is teach in this batch */
	private String technology;
	/** To store the mentors name of this batch */
	private String mentors;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String startDate;
	private String endDate;

	public Batch() {
	}

	public Batch(int id, int trainingDays, int totalCandidates, String clientShortName, String batchName, String type,
			String status, String technology, String mentors, String startDate, String endDate) {
		super();
		this.id = id;
		this.trainingDays = trainingDays;
		this.totalCandidates = totalCandidates;
		this.clientShortName = clientShortName;
		this.batchName = batchName;
		this.type = type;
		this.status = status;
		this.technology = technology;
		this.mentors = mentors;
		this.startDate = startDate;
		this.endDate = endDate;

	}

	/** Getters and Setters of the Batch Class */

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

}
