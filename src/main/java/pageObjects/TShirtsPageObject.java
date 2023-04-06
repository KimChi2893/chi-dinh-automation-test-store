package pageObjects;

import commons.BasePage;
import org.openqa.selenium.*;
import pageUIs.TShirtsPageUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TShirtsPageObject extends BasePage {

    WebDriver driver;
    public TShirtsPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isTShirtsBreadCrumbDisplayed() {
        waitForElementVisible(driver, TShirtsPageUI.TSHIRTS_BREAD_CUMB);
        return isElementDisplayedInDOM(driver, TShirtsPageUI.TSHIRTS_BREAD_CUMB);
    }


    public void selectItemInSortByDropwbox(String itemText) {
        waitForElementClickable(driver, TShirtsPageUI.SORT_BY_DROPDOWN);
        selectItemInDefaultDropdown(driver, TShirtsPageUI.SORT_BY_DROPDOWN, itemText);
    }

    public boolean isItemsPriceSortedAscending() {
        waitForElementVisible(driver, TShirtsPageUI.ITEM_PRICE);
        List<WebElement> itemPriceElement= getListElement(driver, TShirtsPageUI.ITEM_PRICE);

        List<Float> itemPriceText = new ArrayList<Float>();

        for (WebElement itemElement : itemPriceElement) {
            itemPriceText.add(Float.valueOf(itemElement.getText().replace("$", "")));
        }

        List<Float>  itemPriceTextSort = new ArrayList<Float> (itemPriceText);
        Collections.sort(itemPriceTextSort);

        return itemPriceText.equals(itemPriceTextSort);
    }

    public String addToCardAnItem() {
        waitForElementClickable(driver, TShirtsPageUI.ENABLED_ADD_TO_CART_ITEM);
        waitForElementVisible(driver, TShirtsPageUI.NAME_OF_ENABLED_ADD_TO_CART_ITEM);
        String addedItemName = getElementText(driver, TShirtsPageUI.NAME_OF_ENABLED_ADD_TO_CART_ITEM);
        clickOnElement(driver, TShirtsPageUI.ENABLED_ADD_TO_CART_ITEM);

        return addedItemName;
    }

    public String getAddedItemNameOnDetailedInfor() {
        waitForElementVisible(driver, TShirtsPageUI.NAME_OF_ADDED_ITEM);
        return getElementText(driver, TShirtsPageUI.NAME_OF_ADDED_ITEM);
    }

    public boolean isDescriptionSectionDisplayed() {
        waitForElementVisible(driver, TShirtsPageUI.DESCRIPTION_SECTION_OF_ADDED_ITEM);
        return isElementDisplayedInDOM(driver, TShirtsPageUI.DESCRIPTION_SECTION_OF_ADDED_ITEM);
    }
}
