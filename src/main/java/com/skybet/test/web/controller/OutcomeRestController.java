package com.skybet.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skybet.test.beans.Market;
import com.skybet.test.beans.Outcome;
import com.skybet.test.web.repository.MarketRepository;
import com.skybet.test.web.repository.OutcomeRepository;

@RestController
@RequestMapping("outcomes")
public class OutcomeRestController {

	@Autowired
	private OutcomeRepository outcomeRepository;

	@Autowired
	private MarketRepository marketRepository;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public List<Outcome> findAll() {
		return outcomeRepository.findAll();
	}

	@RequestMapping(value = "/findByOutcomeId/{outcomeId}", method = RequestMethod.GET, produces = "application/json")
	public Outcome findByMarketId(@PathVariable("outcomeId") String outcomeId) {
		return outcomeRepository.findByOutcomeId(outcomeId);
	}

	@RequestMapping(value = "/findByMarketId/{marketId}", method = RequestMethod.GET, produces = "application/json")
	public List<Outcome> findByEventId(@PathVariable("marketId") String marketId) {
		Market market = marketRepository.findByMarketId(marketId);
		return outcomeRepository.findByOutcomeIds(market.getOutcomesRef());
	}
}