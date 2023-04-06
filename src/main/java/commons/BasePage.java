package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    public static BasePage getBasePageInstance() {
        return new BasePage();
    }

    private By getByLocator(String locator) {
        By by = null;

        if (locator.startsWith("id=") || locator.startsWith("ID=") || locator.startsWith("Id=")) {
            by = By.id(locator.substring(3));
        } else if(locator.startsWith("class=") || locator.startsWith("Class=") || locator.startsWith("CLASS=")) {
            by = By.className(locator.substring(6));

        }else if(locator.startsWith("name=") || locator.startsWith("Name=") || locator.startsWith("NAME=")) {
            by = By.name(locator.substring(5));

        }else if(locator.startsWith("css=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
            by = By.cssSelector(locator.substring(4));

        }else if(locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=") || locator.startsWith("Xpath=")) {
            by = By.xpath(locator.substring(6));

        }else {
            throw new RuntimeException("The locator is not valid");
        }

        return by;
    }

    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public boolean isElementDisplayedInDOM(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isDisplayed();
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));

    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locator)).perform();
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void clickOnElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText) {
        Select select = new Select(getWebElement(driver, locator));
        select.selectByVisibleText(itemText);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }
}
