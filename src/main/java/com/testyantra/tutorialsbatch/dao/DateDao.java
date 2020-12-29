package com.testyantra.tutorialsbatch.dao;

import org.springframework.data.repository.CrudRepository;

import com.testyantra.tutorialsbatch.entities.Dates;

/**
 * Interface for CRUD operation for BatchWeek Entity
 * 
 * @author Jalaj Kumar
 */

public interface DateDao extends CrudRepository<Dates, Integer> {

}
