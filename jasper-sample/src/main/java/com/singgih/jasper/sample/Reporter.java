package com.singgih.jasper.sample;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reporter {
	public static void main(String[] args) throws Exception {
		EmployeeService dataBeanMaker = new EmployeeService();
		List dataBeanList = dataBeanMaker.getEmployeeList();
		Summary summary = new Summary();
		summary.setBranchCode("0003");
		summary.setBranchName("Branch Name");
		summary.setReportDate(new Date());
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("branchCode", "0003");
		parameters.put("branchName", "Branch Name");
		parameters.put("reportDate", new Date());
		parameters.put("subReportDataSource", dataBeanMaker.getAddressList());
		
		parameters.put("reportTitle","Title");
//		new JasperService().createPdfReportFile("E:/riset/workspace-riset-3/jasper-sample/src/main/resources/sample_report.jrxml", parameters, dataBeanList,
//				"D://sample.report1.pdf");
		new JasperService().previewReport("E:/riset/workspace-riset-3/jasper-sample/src/main/resources/sample_report.jrxml", parameters, dataBeanList);
	}
}
