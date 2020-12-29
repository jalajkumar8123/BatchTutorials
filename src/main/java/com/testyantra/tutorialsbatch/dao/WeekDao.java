package com.testyantra.tutorialsbatch.dao;

import org.springframework.data.repository.CrudRepository;

import com.testyantra.tutorialsbatch.entities.Week;

/**
 * Interface for CRUD operation for BatchWeek Entity
 * 
 * @author Jalaj Kumar
 */
public interface WeekDao extends CrudRepository<Week, Integer> {

}
