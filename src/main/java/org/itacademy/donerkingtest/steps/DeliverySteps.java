package org.itacademy.donerkingtest.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.itacademy.donerkingtest.pages.DeliveryPage;
import org.itacademy.donerkingtest.utils.WaitUtils;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DeliverySteps {

    private DeliveryPage deliveryPage;

    public DeliverySteps(WebDriver driver) {
        deliveryPage = new DeliveryPage(driver);
    }

    @Step("Enter Field Street")
    public void openDeliveryPage() {
        WaitUtils.waitForVisibility(deliveryPage.getButtonDelivery());
        deliveryPage.getButtonDelivery().click();
    }

    @Step("Enter Field Street")
    public void enterFieldStreet(String street) {
        WaitUtils.waitForVisibility(deliveryPage.getFieldStreet());
        deliveryPage.getFieldStreet().sendKeys(street);
    }

    @Step("Get Field Street")
    public String getFieldStreet() {
        WaitUtils.waitForVisibility(deliveryPage.getFieldStreet());
        return deliveryPage.getFieldStreet().getAttribute("value");
    }

    @Step("Enter Field Building")
    public void enterFieldBuilding(String building) {
        WaitUtils.waitForVisibility(deliveryPage.getFieldBuilding());
        deliveryPage.getFieldBuilding().sendKeys(building);
    }

    @Step("Click Button Check")
    public void clickButtonCheck() {
        WaitUtils.waitForVisibility(deliveryPage.getButtonCheck());
        deliveryPage.getButtonCheck().click();
    }

    @Step("Get status")
    public String status() {
        WaitUtils.waitForVisibility(deliveryPage.getStatus());
        String status = deliveryPage.getStatus().getAttribute("class");
        log.info("STATUS: " + status);
        return status;
    }
}
