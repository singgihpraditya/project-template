package com.singgih.velocity.util;

import java.util.Map;

public class Paging {
	public static void generatePage(Map<String, Object> model, int page,
			int recordCount, int pageSize) {
		int pageCount = 0;
		pageCount = (recordCount / pageSize);
		if (recordCount % pageSize != 0)
			pageCount++;
		int lowerLimit = page - 3;
		if (lowerLimit < 0)
			lowerLimit = 0;
		int upperLimit = lowerLimit + 6;

		if (upperLimit > (pageCount - 1))
			upperLimit = pageCount - 1;
		if (pageCount > 8 && (upperLimit - lowerLimit) < 6) {
			lowerLimit -= (6 - (upperLimit - lowerLimit));
		}
		model.put("pageCount", new Integer(pageCount));
		model.put("lowerLimit", new Integer(lowerLimit));
		model.put("upperLimit", new Integer(upperLimit));
		model.put("selPage", new Integer(page));
	}
}
