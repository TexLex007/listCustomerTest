package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage {
	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[7]/a[2]")
	WebElement DELETE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[text() = 'OK']")
	WebElement OK_BUTTON_ELEMENT;

	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[5]")
	WebElement INSERTED_EMAIL_ELEMENT;

	public void verifyCustomerIsAddedAndDelete(String email) {
		String actual = INSERTED_EMAIL_ELEMENT.getText();
		Assert.assertEquals(actual, email, "Account not found in customer list");
		if (actual.contains(email)) {
			DELETE_BUTTON_ELEMENT.click();
			OK_BUTTON_ELEMENT.click();
		}
	}

}
