package com.skybet.test.beans;

import java.util.List;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "com.skybet.test.beans.Market")
@CompoundIndexes({ @CompoundIndex(name = "marketId_1", def = "{'marketId': 1}") })
public class Market {
	
    @Indexed(direction = IndexDirection.ASCENDING)
	private String marketId;
	private String name;
	private Boolean displayed;
	private Boolean suspended;
    @DBRef
    private List<String> outcomes;
	
	public Market() {
		super();
	}
	
	public Market(String marketId, String name, Boolean displayed, Boolean suspended) {
		super();
		this.marketId = marketId;
		this.name = name;
		this.displayed = displayed;
		this.suspended = suspended;
	}

	public List<String> getOutcomesRef() {
		return outcomes;
	}

	public void setOutcomesRef(List<String> outcomes) {
		this.outcomes = outcomes;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public Boolean getDisplayed() {
		return displayed;
	}
	public void setDisplayed(Boolean displayed) {
		this.displayed = displayed;
	}
	public Boolean getSuspended() {
		return suspended;
	}
	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}
}
