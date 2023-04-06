package pageObjects;

import org.openqa.selenium.*;

public class PageGeneratorManager {
    public static HomePageObject getHomePageObject(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static TShirtsPageObject getTShirtsPageObject(WebDriver driver) {
        return new TShirtsPageObject(driver);
    }
}
