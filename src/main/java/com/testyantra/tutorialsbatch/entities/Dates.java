package com.testyantra.tutorialsbatch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Class is an Entity class to store the Date Object details which is
 * having some members of it
 * 
 * @author Jalaj kumar
 */
@Entity
public class Dates {

	/** To store the private key value of this class as Id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/** To store the Date of this class */
	private String date;
	/** To store the Status of this class */
	private String status;

	public Dates() {
	}

	/** Providing getters and Setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
