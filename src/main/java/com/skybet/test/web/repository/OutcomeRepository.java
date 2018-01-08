package com.skybet.test.web.repository;

import java.util.List;

import com.skybet.test.beans.Outcome;

public interface OutcomeRepository  {
    
	public List<Outcome> findAll();
	
    public Outcome findByOutcomeId(String marketId);
    
	public List<Outcome> findByOutcomeIds(List<String> ids);
	
}
