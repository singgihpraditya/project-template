package com.singgih.freemarker.pojo;

import com.google.common.base.Objects;

public class Pagination {
	private int pageSize;
	private int totalRecord;
	private int currentPage;
	private int totalPage;
	private int totalLink;
	private int startPage;
	private int endPage;
	
	private String url;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTotalLink() {
		return totalLink;
	}

	public void setTotalLink(int totalLink) {
		this.totalLink = totalLink;
	}

	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	@Override
	public String toString() {
		return Objects.toStringHelper(getClass()).add("pageSize", pageSize)
				.add("totalRecord", totalRecord)
				.add("currentPage", currentPage).add("totalPage", totalPage)
				.add("url", url).add("totalLink", totalLink)
				.add("startPage", startPage).add("endPage", endPage).
				toString();
	}
}
