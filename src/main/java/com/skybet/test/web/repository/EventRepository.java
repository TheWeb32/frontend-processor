package com.skybet.test.web.repository;

import java.util.List;

import com.skybet.test.beans.Event;

public interface EventRepository  {
    
    List<Event> findAll();
	
    Event findByEventId(String eventId);
}
