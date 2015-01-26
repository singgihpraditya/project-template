package com.singgih.lucene.sample.model;

import java.util.Date;
import java.util.List;

import com.google.common.base.Objects;

public class Result<T extends Indexable> {
	private Date searchDate;
	private List<T> hits;
	private long elapsedTime;
	private boolean match;
	private int totalHits;

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}

	public List<T> getHits() {
		return hits;
	}

	public void setHits(List<T> hits) {
		this.hits = hits;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

	public boolean isMatch() {
		return match;
	}

	public int getTotalHits() {
		return totalHits;
	}

	public void setTotalHits(int totalHits) {
		this.totalHits = totalHits;
	}
	
}
