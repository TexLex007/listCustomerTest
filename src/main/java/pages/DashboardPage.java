package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@class = 'col-lg-12']")
	WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.CSS, using = ".loader-overlay.loaded")
	WebElement LOADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")
	WebElement CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMER_ELEMENT;
	public void verifyDashBoardPage() {
	verifyElement(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard", "Dashboard Page not Found!!");
	}
	
	public void clickCustomer() {
		invisibilityOfLoader(driver, 10, LOADER_ELEMENT);
		CUSTOMER_ELEMENT.click();
	}

	public void clickAddCustomer() {
		ADD_CUSTOMER_ELEMENT.click();

	}
	public void clickListCustomer() {
		invisibilityOfLoader(driver, 10, LOADER_ELEMENT);
		LIST_CUSTOMER_ELEMENT.click();
	}
}
