package com.singgih.jersey.rest.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

@XmlRootElement
public class ArtistVo extends BaseVo {
	private String name;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this.getClass())
				.add("code", code)
				.add("message", message)
				.add("name", name)
				.omitNullValues()
				.toString();
	}
}
