import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.TShirtsPageObject;
import reportConfig.ExtentTestManager;
import java.lang.reflect.Method;

public class Automation_Test_Store_Challenges extends BaseTest {

	String browserName;
	WebDriver driver;
	HomePageObject homePage;
	TShirtsPageObject tShirtsPage;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		this.browserName =  browserName;
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void TC_1_Verify_Display_Home_Page(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + browserName, "TC_1_Open the home page of the Automation test Store");

		ExtentTestManager.getTest().log(Status.INFO, "Verify display the Welcome message on the home page");
		// Verify display an element on the home page
		// Verify display Welcome message on the home page
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	}

	@Test
	public void TC_2_Hover_To_APPAREL_And_ACCESSORIES_Menu_And_Verify_Categories(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + browserName, "TC_2_Hover To APPAREL And ACCESSORIES Menu And Verify Categories");
		ExtentTestManager.getTest().log(Status.INFO, "TC_2 - Step 1: Hover the mouse to APPAREL & ACCESSORIES menu");
		homePage.hoverToApparelAndAccessoriesMenu();

		ExtentTestManager.getTest().log(Status.INFO, "TC_2 - Step 2: Verify display Shoes and T-shirts categories in APPAREL & ACCESSORIES menu");
		ExtentTestManager.getTest().log(Status.INFO, "TC_2 - Step 2.1: Verify display Shoes category in APPAREL & ACCESSORIES menu");
		Assert.assertTrue(homePage.isShoesCategoryDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "TC_2 - Step 2.2: Verify display T-shirts category in APPAREL & ACCESSORIES menu");
		Assert.assertTrue(homePage.isTShirtsCategoryDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "TC_2 - Step 3: Click on T-shirts category");
		tShirtsPage = homePage.clickOnTShirtsCategory();
	}

	@Test
	public void TC_3_Verify_Display_TShirts_Page(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + browserName, "TC_3_Verify display T-shirts Page");
		ExtentTestManager.getTest().log(Status.INFO, "Verify display the TShirt Page");
		// Verify display an element on the TShirt Page
		// Verify display the breadcrumb "T-shirts" on the TShirt Page
		Assert.assertTrue(tShirtsPage.isTShirtsBreadCrumbDisplayed());
	}

	@Test
	public void TC_4_Select_Sort_By_Price_Low_To_High_On_TShirts_Page(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + browserName, "TC_4_Select Sort By Price Low > High on the TShirt Page");
		ExtentTestManager.getTest().log(Status.INFO, "Select Sort By Price Low > High on the T-shirts Page");
		tShirtsPage.selectItemInSortByDropwbox("Price Low > High");
	}

	@Test
	public void TC_5_Verify_That_All_Items_Were_Sorted_By_Price_Low_To_High(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + browserName, "TC_5_Verify that all items were sorted by Price Low > High");
		ExtentTestManager.getTest().log(Status.INFO, "Verify that all items were sorted by Price Low > High");
		Assert.assertTrue(tShirtsPage.isItemsPriceSortedAscending());
	}

	@Test
	public void TC_6_Add_To_Card_And_Item_And_Verify_Display_The_Item_Detailed_Information(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + browserName, "TC_6_Add To Card An Item And Verify Display The Item Detailed Information");
		ExtentTestManager.getTest().log(Status.INFO, "TC_6 - Step 1: Add To Card An Item");
		// Choose the first item with an enabled "Add to Cart" icon in the list
		String itemName = tShirtsPage.addToCardAnItem().toLowerCase();

		ExtentTestManager.getTest().log(Status.INFO, "TC_6 - Step 2: Verify Display The Item Detailed Information");
		ExtentTestManager.getTest().log(Status.INFO, "TC_6 - Step 2.1: Verify display the added Item Name");
		Assert.assertEquals(itemName, tShirtsPage.getAddedItemNameOnDetailedInfor().toLowerCase());

		// Verify display item detailed information. Ex: Description, Colour, Size,...
		// I select the Description to verify instead of all information
		ExtentTestManager.getTest().log(Status.INFO, "TC_6 - Step 2.2: Verify display the description of the added Item");
		Assert.assertTrue(tShirtsPage.isDescriptionSectionDisplayed());
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}