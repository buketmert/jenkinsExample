package base;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {
	public RemoteWebDriver driver;
	public static String browser;
	public static int WAIT_TIME = 15;
	public static int IMPLICITYLY_WAIT = 7;
	private static int PAGE_LOAD_TIMEOUT = 30;

	@Before
	public void initialize() throws Exception {
		browser = System.getProperty("browser");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--ignore-certifcate-errors");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--disable-plugins");
		chromeOptions.addArguments("--disable-plugins-discovery");
		chromeOptions.addArguments("--disable-preconnect");
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("'--dns-prefetch-disable'");
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.addArguments("test-type");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver111.exe");
		driver = new ChromeDriver(chromeOptions);

		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICITYLY_WAIT, TimeUnit.SECONDS);
		driver.get("https://hepsiburada.com");

	}

	public void scrollToElement(RemoteWebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)", "");
	}

	public boolean isElementPresent(RemoteWebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MICROSECONDS);
		if (driver.findElements(by).size() > 0) {
			driver.manage().timeouts().implicitlyWait(IMPLICITYLY_WAIT, TimeUnit.MICROSECONDS);
			return true;
		} else {
			driver.manage().timeouts().implicitlyWait(IMPLICITYLY_WAIT, TimeUnit.MICROSECONDS);
			return false;
		}
	}

	protected void finished(Description description) {
		if (driver != null)
			driver.quit();
		System.out.println("Test is done");
	}
}
