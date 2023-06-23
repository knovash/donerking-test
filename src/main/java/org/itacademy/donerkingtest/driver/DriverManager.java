package org.itacademy.donerkingtest.driver;

import lombok.extern.log4j.Log4j2;
import org.itacademy.donerkingtest.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Log4j2
public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            Config.getProperties();
            System.setProperty("webdriver.chrome.driver", Config.getChromeDriver());
            driver = new ChromeDriver();
            log.info("DRIVER: " + driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static void quitDriver() {
        log.info("DRIVER QUIT");
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}