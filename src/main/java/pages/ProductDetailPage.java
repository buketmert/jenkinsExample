package pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.BasePage;

public class ProductDetailPage extends BasePage {
	private RemoteWebDriver driver;

	public ProductDetailPage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, BasePage.WAIT_TIME), this);
	}

	public ProductDetailPage goToComment() {
		driver.manage().timeouts().implicitlyWait(IMPLICITYLY_WAIT, TimeUnit.SECONDS);
		newTab();
		WebElement review = driver.findElement(By.xpath("//a[@id='productReviews']"));
		review.click();
		scrollToElement(driver);
		return this;
	}

	public ProductDetailPage yesForFirstComment() {
		WebElement firstComment = driver
				.findElement(By.xpath("(//div[@class='thumbsUp hermes-ReviewCard-module-lOsa4wAwncdp3GgzpaaV'])[1]"));
		firstComment.click();
		System.out.println("Yorum Onaylandý.");
		return this;
	}

	public void newTab() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(driver.getTitle());
	}

	public ProductDetailPage seeCongrats() {
		String congrats = "(//span[contains(text(),'Teþekkür Ederiz.')])[1]";
		isElementPresent(driver, By.xpath(congrats));
		System.out.println("Teþekkür Ederiz. mesajý görüntülendi");
		return this;
	}
}
