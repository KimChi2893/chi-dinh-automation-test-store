package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isWelcomeMessageDisplayed() {
        waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE);
        return isElementDisplayedInDOM(driver, HomePageUI.WELCOME_MESSAGE);
    }

    public void hoverToApparelAndAccessoriesMenu() {
        sleepInSecond(1);
        waitForElementVisible(driver, HomePageUI.APPAREL_AND_ACCESSORIES_MENU);
        hoverMouseToElement(driver, HomePageUI.APPAREL_AND_ACCESSORIES_MENU);
    }

    public boolean isShoesCategoryDisplayed() {
        waitForElementVisible(driver, HomePageUI.SHOES_CATEGORY);
        return isElementDisplayedInDOM(driver, HomePageUI.SHOES_CATEGORY);
    }

    public boolean isTShirtsCategoryDisplayed() {
        waitForElementVisible(driver, HomePageUI.TSHIRTS_CATEGORY);
        return isElementDisplayedInDOM(driver, HomePageUI.TSHIRTS_CATEGORY);
    }

    public TShirtsPageObject clickOnTShirtsCategory() {
        waitForElementClickable(driver, HomePageUI.TSHIRTS_CATEGORY);
        clickOnElement(driver, HomePageUI.TSHIRTS_CATEGORY);
        return PageGeneratorManager.getTShirtsPageObject(driver);
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
