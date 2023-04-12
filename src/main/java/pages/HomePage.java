package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.BasePage;

public class HomePage extends BasePage {
	private RemoteWebDriver driver;

	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, BasePage.WAIT_TIME), this);
	}

	public HomePage keywordIsSearched() {
		WebElement searchElement = driver.findElement(By.className("theme-IYtZzqYPto8PhOx3ku3c"));
		searchElement.sendKeys("Iphone");
		searchElement.sendKeys(Keys.RETURN);
		System.out.println("searched for IPHONE !!!");
		return this;
	}

	public HomePage goToFirstLink() {
		driver.manage().timeouts().implicitlyWait(IMPLICITYLY_WAIT, TimeUnit.SECONDS);
		WebElement firstElement = driver.findElement(By.xpath("//li[@id='i0']//div//a"));
		firstElement.click();
		System.out.println("Product detail page");
		return this;

	}

}
