package com.testyantra.tutorialsbatch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This Class is Mapping Class of two entity classes which are Batch.class and
 * Week. class taking foreign keys of Batch.class and Week.class returns the
 * Mapped Batch Object and Week Object
 * 
 * @author Jalaj Kumar
 * 
 */
@Entity
public class BatchWeek {

	/** To store the private key value of this class as Id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** To Map the Batch Class with an aggrigation of Many to One */
	@ManyToOne
	@JoinColumn(name = "batchid", referencedColumnName = "id", nullable = false)
	private Batch batch;

	/** To Map the Week Class with an aggrigation of Many to One */
	@ManyToOne
	@JoinColumn(name = "weekid", referencedColumnName = "id", nullable = false)
	private Week week;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

}
