package com.singgih.freemarker.sample;

import com.singgih.freemarker.pojo.Pagination;

public class PaginationUtil {
	public Pagination paginate(int pageSize, int totalRecord, int currentPage, String url) {
	
		
		Pagination pagination = new Pagination();
		pagination.setPageSize(pageSize);
		pagination.setTotalRecord(totalRecord);
		pagination.setUrl(url);
		pagination.setCurrentPage(currentPage);
		pagination.setTotalPage(Math.round(new Float(new Double(totalRecord)/new Double(pageSize)))); 
		pagination.setTotalLink(5);
		
		int startRow = currentPage - (pagination.getTotalLink() / 2);
		startRow = startRow <= 0?1:startRow;
//		System.out.println(startRow+" "+currentPage);
		int endRow = startRow==1?pagination.getTotalLink():currentPage+(pagination.getTotalLink() / 2);
		
//		endRow = endRow < pagination.getTotalLink()?pagination.getTotalLink() :currentPage+1+pagination.getTotalLink() - startRow;
	
//	
//		System.out.println(startRow+" "+endRow);
		endRow = endRow > pagination.getTotalPage()?pagination.getTotalPage() : endRow;
		
//		
		startRow = endRow == pagination.getTotalPage()? endRow - (pagination.getTotalLink() -1): startRow;		
//		
		System.out.println(startRow+" "+endRow);
		pagination.setStartPage(startRow);
		pagination.setEndPage(endRow);
//		
		return pagination;
	}
}
