package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;
import util.ExelReader;
import util.PropertyFileReader;

public class AddCustomerTest {
	WebDriver driver;
	@Test
	public void userShouldBeAbleToAddCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = BrowserFactory.setup();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		PropertyFileReader pfreader = new PropertyFileReader();
		loginPage.insertUserName(pfreader.getValueOf("username"));
		loginPage.insertPassword(pfreader.getValueOf("password"));
		loginPage.clickLoginButton();
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashBoardPage();

		dashboardPage.clickCustomer();
		dashboardPage.clickAddCustomer();
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		
		ExelReader exlRead = new ExelReader();
		String fullName = exlRead.getValueOfColumn("fullName", 2);
		String company = exlRead.getValueOfColumn("Company", 2);
		String email = exlRead.getValueOfColumn("Email", 2);
		String phone = exlRead.getValueOfColumn("Phone", 2);
		String zip = exlRead.getValueOfColumn("Zip", 2);
		String country = exlRead.getValueOfColumn("Country", 2);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.clickSave();
		
		addCustomerPage.verifyCustomerIsAdded(fullName);

		Thread.sleep(5000);
		BrowserFactory.tearDown();
	}

}
