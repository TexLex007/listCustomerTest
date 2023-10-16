package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LoginPage;
import util.BrowserFactory;
import util.PropertyFileReader;

public class LoginTest {
	WebDriver driver;
	@Test
	public void userShouldBeAbleToLogin() throws InterruptedException, EncryptedDocumentException, IOException {
		
		driver = BrowserFactory.setup();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		PropertyFileReader pfreader = new PropertyFileReader();
		loginPage.insertUserName(pfreader.getValueOf("username"));
		loginPage.insertPassword(pfreader.getValueOf("password"));
		loginPage.clickLoginButton();
		
		
		
		Thread.sleep(5000);
		BrowserFactory.tearDown();
		
	}
}
