package com.singgih.jasper.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;

public class JasperService {
	Logger log = Logger.getLogger("com.singgih.jasper.sample");

	private Stopwatch stopwatch = null;

	protected void startTimer() {
		stopwatch = new Stopwatch().start();
	}

	protected void stopTimer() {
		log.debug("Executed on : " + (stopwatch.elapsed(TimeUnit.MILLISECONDS)) + " ms");
	}

	public byte[] createPdfReport(String jasperFile, Map<String, Object> parameters, List dataSourceList) {
		startTimer();
	
		EmployeeService dataBeanMaker = new EmployeeService();
		List<Employee> dataBeanList = dataBeanMaker.getEmployeeList();
		byte[] output = null;
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		try {
//			InputStream inputStream = Reporter.class.getClassLoader().getResourceAsStream(jasperFile);
//			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = getCompiledJasperReport(jasperFile);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
			output = JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (JRException fuckingException) {
			fuckingException.printStackTrace();
		}
		stopTimer();
		return output;
	}

	public void createPdfReportFile(String jasperFile, Map<String, Object> parameters, List dataSourceList, String outputFile) {
		byte[] output = createPdfReport(jasperFile, parameters, dataSourceList);
		try {
			FileOutputStream outputStream = new FileOutputStream(outputFile);
			outputStream.write(output);
			outputStream.close();
		} catch (FileNotFoundException fuckingException) {
			fuckingException.printStackTrace();
		} catch (IOException fuckingException) {
			fuckingException.printStackTrace();
		}
	}
	
	private JasperReport getCompiledJasperReport(String jasperFile){
		JasperReport jasperReport = null;
		String compiledJasperReportName = jasperFile.replace("jrxml", "jasper");
		try {
			File file = new File(compiledJasperReportName);
			if(!file.exists()){
				JasperCompileManager.compileReportToFile(jasperFile,compiledJasperReportName);
			}
			jasperReport = (JasperReport) JRLoader.loadObject(file);
		} catch (JRException e) {
			e.printStackTrace();
		}
		return jasperReport;
	}
	
	public void previewReport(String jasperFile, Map<String, Object> parameters, List dataSourceList) {
		startTimer();
		
		EmployeeService dataBeanMaker = new EmployeeService();
		List<Employee> dataBeanList = dataBeanMaker.getEmployeeList();
	
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		try {
//			InputStream inputStream = Reporter.class.getClassLoader().getResourceAsStream(jasperFile);
//			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = getCompiledJasperReport(jasperFile);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
//			JasperViewer viewer = new JasperViewer(jasperPrint);
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException fuckingException) {
			fuckingException.printStackTrace();
		}
		stopTimer();
	}
}
