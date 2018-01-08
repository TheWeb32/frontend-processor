package com.skybet.test.web.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.skybet.test.beans.Event;

@Repository
public class EventRepositoryImpl implements EventRepository {

	@Autowired
	private MongoOperations mongoOps;
	
	@Override
	public Event findByEventId(String eventId) {
		Query query = new Query(Criteria.where("eventId").is(eventId));
		return mongoOps.find(query, Event.class).iterator().next();
	}

	@Override
	public List<Event> findAll() {
		return mongoOps.findAll(Event.class);
	}
    

}
