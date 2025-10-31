package testutils;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;
import utils.DriverManager;



public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✓ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("✗ Test Failed: " + result.getName());
        
        // Use ScreenshotUtil to capture screenshot on failure
     // Get WebDriver instance from DriverManager
        WebDriver driver = DriverManager.getDriver();
        
        // Create ScreenshotUtil instance with driver
        ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
        
        // Capture screenshot with test name
        String screenshotPath = screenshotUtil.captureScreenshot(result.getName());
        
        System.out.println("Screenshot saved at: " + screenshotPath);
        }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⊘ Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("! Test Failed But Within Success Percentage: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }
}
