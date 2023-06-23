package org.itacademy.donerkingtest.utils;

import io.qameta.allure.Attachment;
import org.itacademy.donerkingtest.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        saveScreenshot();
        saveTextLog(result.getMethod().getConstructorOrMethod().getName() + "Success screenshot saved");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
        saveTextLog(result.getMethod().getConstructorOrMethod().getName() + "Fail screenshot saved");
    }
}
