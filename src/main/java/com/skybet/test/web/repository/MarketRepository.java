package com.skybet.test.web.repository;

import java.util.List;

import com.skybet.test.beans.Market;

public interface MarketRepository  {
    
	public List<Market> findAll();
	
    public Market findByMarketId(String marketId);
    
	public List<Market> findByMarketIds(List<String> ids);
	
}
