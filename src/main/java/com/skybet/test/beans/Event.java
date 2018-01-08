package com.skybet.test.beans;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "com.skybet.test.beans.Event")
@CompoundIndexes({ @CompoundIndex(name = "eventId_1", def = "{'eventId': 1}") })
public class Event {

    @Indexed(direction = IndexDirection.ASCENDING)
	private String eventId;
	private String category;
	private String subCategory;
	private String name;
	private Date startTime;
	private Boolean displayed;
	private Boolean suspended;
    @DBRef
    private List<String> markets;

    @PersistenceConstructor
    public Event(String eventId, String category, String subCategory, String name, Date startTime, Boolean displayed,
			Boolean suspended, List<String> markets) {
		super();
		this.eventId = eventId;
		this.category = category;
		this.subCategory = subCategory;
		this.name = name;
		this.startTime = startTime;
		this.displayed = displayed;
		this.suspended = suspended;
		this.markets = markets;
	}

	public List<String> getMarketsRef() {
		return markets;
	}

	public void setMarketsRef(List<String> markets) {
		this.markets = markets;
	}

	public Event() {
    }

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
