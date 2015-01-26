package com.singgih.lucene.sample.model;

import com.google.common.base.Objects;

public class Book extends Indexable {
	private String isbn;
	private String title;

	public Book() {
	}

	public Book(String indexId, String isbn, String title) {
		this.indexId = indexId;
		this.isbn = isbn;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String toString() {
		return Objects.toStringHelper(getClass()).add("indexId", indexId)
				.add("isbn", isbn).add("title", title).toString();
	}

}
