package com.skybet.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skybet.test.beans.Event;
import com.skybet.test.beans.Market;
import com.skybet.test.web.repository.EventRepository;
import com.skybet.test.web.repository.MarketRepository;

@RestController
@RequestMapping("markets")
public class MarketRestController {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private MarketRepository marketRepository;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public List<Market> findAll() {
		return marketRepository.findAll();
	}

	@RequestMapping(value = "/findByMarketId/{marketId}", method = RequestMethod.GET, produces = "application/json")
	public Market findByMarketId(@PathVariable("marketId") String marketId) {
		return marketRepository.findByMarketId(marketId);
	}

	@RequestMapping(value = "/findByEventId/{eventId}", method = RequestMethod.GET, produces = "application/json")
	public List<Market> findByEventId(@PathVariable("eventId") String eventId) {
		Event event = eventRepository.findByEventId(eventId);
		return marketRepository.findByMarketIds(event.getMarketsRef());
	}
}