package com.testyantra.tutorialsbatch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This is class is an Entity class which is store the details of the Week
 * Object
 * 
 * @author Jalaj kumar
 */

@Entity
public class Week {

	/** To store the private key value of this class as Id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/** To store the Start date detail of this class */
	private String startDate;
	/** To store the End date detail of this class */
	private String endDate;
	/** TO store the Number of Weeks are Present in it */
	private int noWeeks;
	/** To store the Number of Days are Present in it */
	private int noDays;

	public Week() {
	}

	public Week(int id, String startDate, String endDate, int noWeeks, int noDays) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.noWeeks = noWeeks;
		this.noDays = noDays;
	}

	/** getters and setters of it */
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
