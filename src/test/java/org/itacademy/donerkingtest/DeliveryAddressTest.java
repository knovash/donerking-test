package org.itacademy.donerkingtest;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.itacademy.donerkingtest.driver.DriverManager;
import org.itacademy.donerkingtest.models.Address;
import org.itacademy.donerkingtest.steps.DeliverySteps;
import org.itacademy.donerkingtest.utils.DataProviderAddresses;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Log4j2
@Listeners
public class DeliveryAddressTest extends BaseTest {

    private DeliverySteps deliverySteps;


    @BeforeClass
    public void beforeClass() {
        driver = DriverManager.getDriver();
        deliverySteps = new DeliverySteps(driver);
    }

    @Description("Verifys search result items")
    @Test(testName = "CheckDelivery",
            dataProvider = "addresses",
            dataProviderClass = DataProviderAddresses.class)
    public void verifyDeliveryTest(Address address) {
        log.info("TEST ADDRESS START");
        deliverySteps.openDeliveryPage();
        deliverySteps.enterFieldStreet(address.getStreet());
        log.info("GET TEXT getFieldStreet " + deliverySteps.getFieldStreet());
        deliverySteps.enterFieldBuilding(address.getBuilding());
        deliverySteps.clickButtonCheck();
        String result = deliverySteps.status();
        Assert.assertEquals(result, "success", "NOT SUCCESS wrong address " + address.getBuilding());
    }
}