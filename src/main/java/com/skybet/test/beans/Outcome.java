package com.skybet.test.beans;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "com.skybet.test.beans.Outcome")
@CompoundIndexes({ @CompoundIndex(name = "outcomeId_1", def = "{'outcomeId': 1}") })
public class Outcome {
	
    @Indexed(direction = IndexDirection.ASCENDING)
	private String outcomeId;
    @Indexed(direction = IndexDirection.ASCENDING)
	private String marketId;
	private String name;
	private String price;
	private Boolean displayed;
	private Boolean suspended;
	
	public Outcome() {
		super();
	}

	public Outcome(String outcomeId, String marketId, String name, String price, Boolean displayed, Boolean suspended) {
		super();
		this.outcomeId = outcomeId;
		this.marketId = marketId;
		this.name = name;
		this.price = price;
		this.displayed = displayed;
		this.suspended = suspended;
	}

	public String getOutcomeId() {
		return outcomeId;
	}

	public void setOutcomeId(String outcomeId) {
		this.outcomeId = outcomeId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
