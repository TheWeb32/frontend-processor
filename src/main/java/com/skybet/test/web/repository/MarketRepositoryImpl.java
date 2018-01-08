package com.skybet.test.web.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.skybet.test.beans.Market;

@Repository
public class MarketRepositoryImpl implements MarketRepository {

	@Autowired
	private MongoOperations mongoOps;
	
	@Override
	public Market findByMarketId(String marketId) {
		Query query = new Query(Criteria.where("marketId").is(marketId));
		return mongoOps.find(query, Market.class).iterator().next();
	}
	
	@Override
	public List<Market> findByMarketIds(List<String> ids) {
		Query query = new Query(Criteria.where("marketId").in(ids));
		return mongoOps.find(query, Market.class);
	}

	@Override
	public List<Market> findAll() {
		return mongoOps.findAll(Market.class);
	}

}
