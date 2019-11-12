package testBase;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	static Map<Integer, ExtentTest> hmap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentReportTest.getInstance();

	public static synchronized ExtentTest getTest() {

		// return hmap.get(Thread.currentThread().getId());

		return (ExtentTest) hmap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {

		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {

		ExtentTest test = extent.createTest(testName);

		hmap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

}
