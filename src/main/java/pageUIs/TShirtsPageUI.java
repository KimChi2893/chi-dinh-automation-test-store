package pageUIs;

public class TShirtsPageUI {
    public static final String TSHIRTS_BREAD_CUMB = "xpath=//section[@class='breadcrumbs']//a[contains(string(), 'T-shirts')]";
    public static final String SORT_BY_DROPDOWN = "css=select#sort";
    public static final String ITEM_PRICE = "css=div.list-inline div.oneprice";
    public static final String ENABLED_ADD_TO_CART_ITEM = "xpath=//div[contains(@class, 'list-inline')]//a[@title='Add to Cart']";
    public static final String NAME_OF_ENABLED_ADD_TO_CART_ITEM = "xpath=//div[contains(@class, 'list-inline')]//a[@title='Add to Cart']/parent::div/parent::div/preceding-sibling::div//a[@class='prdocutname']";
    public static final String NAME_OF_ADDED_ITEM = "css=h1.productname span";
    public static final String DESCRIPTION_SECTION_OF_ADDED_ITEM = "css=h1.productname span";
}