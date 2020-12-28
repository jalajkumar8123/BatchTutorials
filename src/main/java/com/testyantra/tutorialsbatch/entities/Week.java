package com.testyantra.tutorialsbatch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Week
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String startDate;
	private String endDate;
	private int noWeeks;
	private int noDays;
	
	//@Autowired
	//private Datedetails datedetails;
	
	public Week() {}

	public Week(int id, String startDate, String endDate, int noWeeks, int noDays) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.noWeeks = noWeeks;
		this.noDays = noDays;
		//this.datedetails = datedetails;
	}

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

}
