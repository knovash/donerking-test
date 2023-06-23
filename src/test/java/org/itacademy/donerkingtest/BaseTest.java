package org.itacademy.donerkingtest;

import lombok.extern.log4j.Log4j2;
import org.itacademy.donerkingtest.driver.DriverManager;
import org.itacademy.donerkingtest.utils.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

@Log4j2
public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforetest() {
        log.info("BEFORE TEST get driver");
        driver = DriverManager.getDriver();
    }

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD open home page: " + Config.getHomePage());
        driver = DriverManager.getDriver();
        driver.get(Config.getHomePage());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void aftertest() {
        log.info("AFTER TEST quit driver");
        DriverManager.quitDriver();
    }
}
