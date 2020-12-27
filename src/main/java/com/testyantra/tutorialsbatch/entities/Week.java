package com.testyantra.tutorialsbatch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Week
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String startdate;
	private String enddate;
	private int noweeks;
	private int nodays;
	
	//@Autowired
	//private Datedetails datedetails;
	
	public Week() {}

	public Week(int id, String startdate, String enddate, int noweeks, int nodays) {
		super();
		this.id = id;
		this.startdate = startdate;
		this.enddate = enddate;
		this.noweeks = noweeks;
		this.nodays = nodays;
		//this.datedetails = datedetails;
	}

	public int getWeekid() {
		return id;
	}

	public void setWeekid(int id) {
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

	/*
	 * public Datedetails getDatedetails() { return datedetails; }
	 * 
	 * public void setDatedetails(Datedetails datedetails) { this.datedetails =
	 * datedetails; }
	 */

	@Override
	public String toString() {
		return "Week [id=" + id + ", startdate=" + startdate + ", enddate=" + enddate + ", noweeks=" + noweeks
				+ ", nodays=" + nodays + ", datedetails="  + "]";
	}
	
	
	
}
