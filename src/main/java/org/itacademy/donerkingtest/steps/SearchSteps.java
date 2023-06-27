package org.itacademy.donerkingtest.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.itacademy.donerkingtest.pages.SearchPage;
import org.itacademy.donerkingtest.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

@Log4j2
public class SearchSteps {

    private SearchPage searchPage;

    public SearchSteps(WebDriver driver) {
        searchPage = new SearchPage(driver);
    }

    @Step("Click search button for show search field")
    public void clickSearchButton() {
        log.info("Click search button for show search field");
        WaitUtils.waitForVisibility(searchPage.getSearchButton());
        searchPage.getSearchButton().click();
    }

    @Step("Enter text in search field")
    public void enterSearchFieldText(String text) {
        log.info("Enter text in search field: " + text);
        WaitUtils.waitForVisibility(searchPage.getSearchField());
        searchPage.getSearchField().sendKeys(text);
    }

    @Step("Click start search button")
    public void clickSearchStartButton() {
        log.info("Click start search button");
        WaitUtils.waitForVisibility(searchPage.getSearchStartButton());
        searchPage.getSearchStartButton().click();
    }

    @Step("Get result list of menu items")
    public SoftAssert getAssert(String menuItem) {
        log.info("Get result list of menu items");
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(searchPage.getResultItems().isEmpty(), "RESULT LIST IS EMPTY");
        searchPage.getResultItems().stream()
                .map(webElement -> webElement.getText().toLowerCase())
                .peek(itemText -> log.info("ITEM: " + itemText))
                .forEach(itemText -> sa.assertTrue(itemText.contains(menuItem), "IT IS NOT: " + menuItem));
        sa.assertAll();
        return sa;
    }
}