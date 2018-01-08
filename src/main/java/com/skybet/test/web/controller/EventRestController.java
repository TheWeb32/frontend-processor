package com.skybet.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skybet.test.beans.Event;
import com.skybet.test.web.repository.EventRepository;

@RestController
@RequestMapping("events")
public class EventRestController {
	
	 @Autowired
	 private EventRepository eventRepository;
		
	    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	    public List<Event> findAll() {
	       return eventRepository.findAll();
	    }
		
	    @RequestMapping(value = "/findByEventId/{eventId}", method = RequestMethod.GET, produces = "application/json")
	    public Event findByEventId(@PathVariable("eventId") String eventId) {
	       return eventRepository.findByEventId(eventId);
	    }
}