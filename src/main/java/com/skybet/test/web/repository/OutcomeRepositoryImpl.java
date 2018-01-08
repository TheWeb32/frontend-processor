package com.skybet.test.web.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.skybet.test.beans.Outcome;

@Repository
public class OutcomeRepositoryImpl implements OutcomeRepository {

	@Autowired
	private MongoOperations mongoOps;
	
	@Override
	public Outcome findByOutcomeId(String outcomeId) {
		Query query = new Query(Criteria.where("outcomeId").is(outcomeId));
		return mongoOps.find(query, Outcome.class).iterator().next();
	}
	
	@Override
	public List<Outcome> findByOutcomeIds(List<String> ids) {
		Query query = new Query(Criteria.where("outcomeId").in(ids));
		return mongoOps.find(query, Outcome.class);
	}

	@Override
	public List<Outcome> findAll() {
		return mongoOps.findAll(Outcome.class);
	}

}
