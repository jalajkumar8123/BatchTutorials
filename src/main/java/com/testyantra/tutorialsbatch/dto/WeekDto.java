package com.testyantra.tutorialsbatch.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.testyantra.tutorialsbatch.entities.Dates;

/**
 * This class is Data Transfer Object Class is having the Members same as Week
 * class and extra added member is Dates class lists and returns the WeekDto
 * objects as response body.The main purpose of this is class is for Customized
 * response body
 * 
 * @author Jalaj Kumar
 */
@Component
public class WeekDto {

	/**
	 * These members are same as Week class members and added one extra member is
	 * List of Dates object
	 */
	private int id;
	private String startDate;
	private String endDate;
	private int noWeeks;
	private int noDays;

	private List<Dates> dates;

	/** getters and setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNoWeeks() {
		return noWeeks;
	}

	public void setNoWeeks(int noWeeks) {
		this.noWeeks = noWeeks;
	}

	public int getNoDays() {
		return noDays;
	}

	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}

	public List<Dates> getDates() {
		return dates;
	}

	public void setDates(List<Dates> dates) {
		this.dates = dates;
	}

}
