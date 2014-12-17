package com.singgih.jasper.sample;

public class Address {
	private String name;
	private String postCode;

	public Address(String name, String postCode) {
		this.name = name;
		this.postCode = postCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
