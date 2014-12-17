package com.singgih.jersey.rest.vo;

import javax.xml.bind.annotation.XmlElement;

import com.google.common.base.Objects;

public class MerchantVo extends BaseVo {
	private String name;
	private String address;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this.getClass())
				.add("code", code)
				.add("message", message)
				.add("name", name)
				.add("address", address)
				.omitNullValues()
				.toString();
	}
}
