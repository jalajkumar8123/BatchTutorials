package com.testyantra.tutorialsbatch.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.testyantra.tutorialsbatch.entities.WeekDate;

/**
 * Interface for CRUD operation for WeekDate Entity
 * 
 * @author Jalaj Kumar
 */

public interface WeekDateDao extends CrudRepository<WeekDate, Integer> {

	List<WeekDate> findAllByweekId(int weekid);

}
