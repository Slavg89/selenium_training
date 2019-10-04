package pl.luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest extends ParentTestSelenium {

    //protected WebDriver driver;


    private void acceptPrivacyPolicy() {
        final By PRIVACY_MODEL_WINDOW_WRAPPER = By.className("alert");
        final By PRIVACY_ACCEPT_BUTTON = By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[2]/button");
        driver.findElement(PRIVACY_MODEL_WINDOW_WRAPPER).findElement(PRIVACY_ACCEPT_BUTTON).click();

    }


    /*@Test
    public void searchResultsPageTitleContainSearchQuerryTest() {

        String searchQuerry = "leather bag";
        final By SEARCH_FIELD = By.id("global-enhancements-search-query");
        final By SEARCH_SUGGESTION_LIST_FIRST =
                By.cssSelector("#global-enhancements-search-suggestions ul div.as-first");

        driver.get("http://www.etsy.com");
        acceptPrivacyPolicy();

        WebElement search_field = driver.findElement(SEARCH_FIELD);

        search_field.clear();
        search_field.sendKeys(searchQuerry);
        //search_field.sendKeys(Keys.ENTER);


        WebElement firstSuggestion = new WebDriverWait(driver, 5).
            until(ExpectedConditions.visibilityOfElementLocated(SEARCH_SUGGESTION_LIST_FIRST));

        firstSuggestion.click();

        Assert.assertTrue(driver.getTitle().contains("Leather bag"));


    }
    */

    @Test
    public void searchResultsTableHeaderContainSearchQuerryPOTest() {
        String searchQuerry = "leather bag";

        EtsyComMainPO etsyCom = new EtsyComMainPO(driver);
        SearchResultsPO etsyResults = new SearchResultsPO(driver);
        etsyCom.goTo()
                .acceptPrivacyPolicy()
                .searchFor(searchQuerry)
                .pickFirstItemInSuggestionsList();
        String searchResultsHeader = etsyResults.getResultsHeader();
        Assert.assertTrue(searchResultsHeader.contains(searchQuerry));
    }



}
