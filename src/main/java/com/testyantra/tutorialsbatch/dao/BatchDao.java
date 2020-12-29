package com.testyantra.tutorialsbatch.dao;

import org.springframework.data.repository.CrudRepository;

import com.testyantra.tutorialsbatch.entities.Batch;

/**
 * Interface for CRUD operation for Batch Entity
 * 
 * @author Jalaj Kumar
 */
public interface BatchDao extends CrudRepository<Batch, Integer> {

}
