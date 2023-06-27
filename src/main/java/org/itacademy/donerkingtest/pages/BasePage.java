package org.itacademy.donerkingtest.pages;

import org.itacademy.donerkingtest.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(DriverManager.getDriver(), this);
        this.driver = driver;
    }
}
