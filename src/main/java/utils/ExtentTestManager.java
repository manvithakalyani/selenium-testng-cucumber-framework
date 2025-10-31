package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static ExtentReports extent;

    public static void setExtent(ExtentReports extentReports) {
        ExtentTestManager.extent = extentReports;
    }

    public static ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName); // Make sure 'extent' is already initialized!
        extentTest.set(test);
        return test;
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void endTest() {
        extentTest.remove();
    }
}
