package testutils;

import org.testng.annotations.Listeners;
import com.aventstack.extentreports.Status;

import utils.ExtentTestManager;


@Listeners(testutils.TestListener.class)

public class BaseTest {
    public void logInfo(String message) {
        ExtentTestManager.getTest().log(Status.INFO, message);
    }
    public void logPass(String message) {
        ExtentTestManager.getTest().log(Status.PASS, message);
    }
    public void logFail(String message) {
        ExtentTestManager.getTest().log(Status.FAIL, message);
    }
    public void logSkip(String message) {
        ExtentTestManager.getTest().log(Status.SKIP, message);
    }
    public void logWarning(String message) {
        ExtentTestManager.getTest().log(Status.WARNING, message);
    }
    public void attachScreenshot(String screenshotPath) {
        ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
    }
    public void logException(Exception e) {
        ExtentTestManager.getTest().fail(e);
    }
}
