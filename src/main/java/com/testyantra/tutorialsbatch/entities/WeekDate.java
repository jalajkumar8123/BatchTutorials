package com.testyantra.tutorialsbatch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This Class is the Mapping Class of two Entity Classes of Week and Date class
 * which is having the foreign keys in it. Returns the Mapped Week and Date
 * object.
 * 
 * @author Jalaj Kumar
 */
@Entity
public class WeekDate {

	/** To store the private key value of this class as Id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** To Map the Week Class with an aggrigation of Many to One */
	@ManyToOne
	@JoinColumn(name = "weekid", referencedColumnName = "id", nullable = false)
	private Week week;

	/** To Map the Dates Class with an aggrigation of Many to One */
	@ManyToOne
	@JoinColumn(name = "dateid", referencedColumnName = "id", nullable = false)
	private Dates date;

	/** getters and setters of it */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public Dates getDate() {
		return date;
	}

	public void setDate(Dates date) {
		this.date = date;
	}

}
