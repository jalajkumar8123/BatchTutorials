package com.testyantra.tutorialsbatch.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.testyantra.tutorialsbatch.entities.Dates;

@Component
public class WeekDto {
	private int id;
	private String startDate;
	private String endDate;
	private int noWeeks;
	private int noDays;

	private List<Dates> dates;

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
