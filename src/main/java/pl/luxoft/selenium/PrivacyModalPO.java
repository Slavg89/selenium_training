package pl.luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivacyModalPO extends BasePO {
    public PrivacyModalPO(WebDriver driver) {
        super(driver);
    }

    final By PRIVACY_MODEL_WINDOW_WRAPPER = By.className("alert");
    final By PRIVACY_ACCEPT_BUTTON = By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[2]/button");

    public void acceptPolicy() {
        getAcceptButton().click();
    }

    private WebElement getAcceptButton() {
        return findElementWithWait(PRIVACY_MODEL_WINDOW_WRAPPER)
                .findElement(PRIVACY_ACCEPT_BUTTON);
    }
}
