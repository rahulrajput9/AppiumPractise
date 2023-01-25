package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getExtendReports() {
		String path=System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter rp= new ExtentSparkReporter(path);
		rp.config().setReportName("Appium Practise");
		rp.config().setDocumentTitle("Test results of Appium Practise");
		
		extent= new ExtentReports();
		extent.attachReporter(rp);
		extent.setSystemInfo("Tester", "Rahul Rajput");
		
		return extent;
	}
	

}
