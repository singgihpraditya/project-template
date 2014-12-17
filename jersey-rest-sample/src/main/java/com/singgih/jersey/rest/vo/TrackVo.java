package com.singgih.jersey.rest.vo;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.common.base.Objects;
import com.singgih.jersey.rest.adapter.XmlDateAdapter;
import com.singgih.jersey.rest.adapter.XmlDateTimeAdapter;

@XmlRootElement
public class TrackVo extends BaseVo {
	private String title;
	private ArtistVo singer;
	private List<MerchantVo> merchants;
	private Date releaseDate;
	private Date createdDateTime;

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public ArtistVo getSinger() {
		return singer;
	}

	@XmlElement(name = "singer")
	public void setSinger(ArtistVo singer) {
		this.singer = singer;
	}

	public List<MerchantVo> getMerchants() {
		return merchants;
	}

	@XmlElement(name = "merchants")
	public void setMerchants(List<MerchantVo> merchants) {
		this.merchants = merchants;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	@XmlElement
	@XmlJavaTypeAdapter(XmlDateAdapter.class)
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@XmlElement
	@XmlJavaTypeAdapter(XmlDateTimeAdapter.class)
	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this.getClass())
				.add("code", code)
				.add("message", message)
				.add("title", title)
				.add("singer", singer)
				.add("merchants", merchants)
				.add("releaseDate", releaseDate)
				.add("createdDateTime", createdDateTime)
				.omitNullValues()
				.toString();
		// return "Track [title=" + title + ", singer=" + singer + "]";
	}

}
