package com.singgih.hibernate4.sample.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.common.base.Objects;

@Embeddable
public class AuditTrail {
	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date_time")
	private String createdDateTime;

	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	@Column(name = "last_updated_date_time")
	private String lastUpdatedDateTime;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}

	public void setLastUpdatedDateTime(String lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(getClass())
				.add("createdBy", createdBy)
				.add("createdDateTime", createdDateTime)
				.add("lastUpdatedBy", lastUpdatedBy)
				.add("lastUpdatedDateTime", lastUpdatedDateTime)
				.toString();
	}
}
