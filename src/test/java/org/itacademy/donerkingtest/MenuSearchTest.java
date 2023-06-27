package org.itacademy.donerkingtest;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.itacademy.donerkingtest.driver.DriverManager;
import org.itacademy.donerkingtest.models.MenuItem;
import org.itacademy.donerkingtest.steps.SearchSteps;
import org.itacademy.donerkingtest.utils.DataProviderMenuItems;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Log4j2
@Listeners
public class MenuSearchTest extends BaseTest {

    private SearchSteps searchSteps;

    @BeforeClass
    public void beforeClass() {
        driver = DriverManager.getDriver();
        searchSteps = new SearchSteps(driver);
    }

    @Description("Verifys search result items")
    @Test(testName = "SearchResultsTest",
            dataProvider = "menuItems",
            dataProviderClass = DataProviderMenuItems.class)
    public void verifySearchTest(MenuItem menuItem) {
        log.info("TEST SEARCH START");
        searchSteps.clickSearchButton();
        searchSteps.enterSearchFieldText(menuItem.getName());
        searchSteps.clickSearchStartButton();
        searchSteps.getAssert(menuItem.getName());
    }
}