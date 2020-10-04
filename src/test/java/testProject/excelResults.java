package testProject;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.common.excelreport.ExcelReportGenerator;

public class excelResults {
	
	public static void main(String[]args) throws ParserConfigurationException, IOException, SAXException
	{
	ExcelReportGenerator.generateExcelReport("ExcelReport.xls" , "C:\\optiimTestCase");
	}
}
