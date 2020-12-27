package com.testyantra.tutorialsbatch.dao;

import org.springframework.data.repository.CrudRepository;

import com.testyantra.tutorialsbatch.entities.Batch;

public interface BatchDao extends CrudRepository<Batch, Integer> {

}
