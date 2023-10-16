package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;
	String randomEmail;
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = ".loader-overlay.loaded")
	WebElement LOADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[@class = 'thumb-info-inner']")
	WebElement PROFILE_ELEMENT;



	public void insertFullName(String fullName) {
		FULL_NAME_ELEMENT.sendKeys(fullName);
	}

	public void selectCompany(String visibleText) {
		dropDownSelector(COMPANY_ELEMENT, visibleText);
	}

	
	static String insertedEmail;
	
	public static String getInsertedEmail() {
		return insertedEmail;
	}

	public void insertEmail(String email) {
		insertedEmail = randomNumGen(666) + email;
		EMAIL_ELEMENT.sendKeys(insertedEmail);
		
	}

	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(randomNumGen(6666) + phone);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}

	public void selectCountry(String visibleText) {
		dropDownSelector(COUNTRY_ELEMENT, visibleText);
	}

	public void clickSave() {
		SAVE_BUTTON_ELEMENT.click();
	}
	public void verifyCustomerIsAdded(String profileName) throws InterruptedException {
		Thread.sleep(3000);
		invisibilityOfLoader(driver, 10, LOADER_ELEMENT);

		Assert.assertEquals(PROFILE_ELEMENT.getText(), profileName, "User was not added!!");
	}

}
