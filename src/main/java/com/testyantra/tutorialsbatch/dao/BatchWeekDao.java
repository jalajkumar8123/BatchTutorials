package com.testyantra.tutorialsbatch.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.testyantra.tutorialsbatch.entities.BatchWeek;

/**
 * Interface for CRUD operation and Customization for BatchWeek Entity
 * 
 * @author Jalaj Kumar
 */
public interface BatchWeekDao extends CrudRepository<BatchWeek, Integer> {

	List<BatchWeek> findAllBybatchId(int batchid);
}
