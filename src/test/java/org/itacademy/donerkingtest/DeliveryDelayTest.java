package org.itacademy.donerkingtest;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.itacademy.donerkingtest.driver.DriverManager;
import org.itacademy.donerkingtest.steps.DeliverySteps;
import org.itacademy.donerkingtest.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Log4j2
@Listeners
public class DeliveryDelayTest extends BaseTest {

    private DeliverySteps deliverySteps;

    @BeforeClass
    public void beforeClass() {
        driver = DriverManager.getDriver();
        deliverySteps = new DeliverySteps(driver);
    }

    @DataProvider
    public Object[][] delays() {
        return new Object[][]{{50}, {500}};
    }

    @Description("Verify delay for address check")
    @Issue("delay for address check")
    @Test(testName = "Delay test", dataProvider = "delays")
    public void verifyDeliveryTest(int time) {
        log.info("TEST DELAY START");
        deliverySteps.openDeliveryPage();
        deliverySteps.enterFieldStreet("Кульман");
        log.info("getFieldStreet " + deliverySteps.getFieldStreet());
        deliverySteps.enterFieldBuilding("15");
        deliverySteps.clickButtonCheck();
        log.info("TIMER " + time);
        WaitUtils.waitMilSeconds(time);
        Assert.assertEquals(deliverySteps.status(), "success", "not enough time to check the address.");
    }
}