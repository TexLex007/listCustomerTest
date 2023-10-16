package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	
	public void dropDownSelector(WebElement webElement, String visibleText) {
		Select s = new Select(webElement);
		s.selectByVisibleText(visibleText);
	}
	public void invisibilityOfLoader(WebDriver driver, int timeInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	public void verifyElement(String expected, String actual, String message) {
		Assert.assertEquals(expected, actual, message);
	}
	
	public int randomNumGen(int bound) {
		Random rand = new Random();
		int generatedNum = rand.nextInt(bound);
		return generatedNum;
	}

}
