package com.testyantra.tutorialsbatch.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.testyantra.tutorialsbatch.entities.Dates;

@Component
public class WeekDto
{
	private int id;
	private String startdate;
	private String enddate;
	private int noweeks;
	private int nodays;
	
	private List<Dates> dates;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNoweeks() {
		return noweeks;
	}

	public void setNoweeks(int noweeks) {
		this.noweeks = noweeks;
	}

	public int getNodays() {
		return nodays;
	}

	public void setNodays(int nodays) {
		this.nodays = nodays;
	}

	public List<Dates> getDates() {
		return dates;
	}

	public void setDates(List<Dates> dates) {
		this.dates = dates;
	}
	
	

}
