package com.singgih.velocity.menu;

import com.google.common.base.Objects;

public class Menu {
	private String id;
	private String name;
	private Menu parent;
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String ur) {
		this.url = ur;
	}

	public String toString() {
		return Objects.toStringHelper(getClass()).add("id", id)
				.add("name", name).add("parent", parent)
				.add("url", url).toString();
	}
}
