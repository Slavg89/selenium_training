package pl.luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePO {

    final int SEARCH_WAIT_TIME = 5;

    protected WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElementWithWait(By locator) {
        return new WebDriverWait(driver, SEARCH_WAIT_TIME).
                until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    protected List<WebElement> findElementsWithWait(By locator) {
        return new WebDriverWait(driver, SEARCH_WAIT_TIME).
                until(ExpectedConditions.
                visibilityOfAllElementsLocatedBy(locator));
    }

}
