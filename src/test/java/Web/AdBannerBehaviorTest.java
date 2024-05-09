package Web;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdBannerBehaviorTest {

	public static void main(String[] args) throws InterruptedException {
		// Test ad banner behavior in Chrome
		testAdBannerBehavior(new ChromeDriver(), "Chrome");
		testAdBannerBehavior(new FirefoxDriver(), "Firefox");

	}

	@SuppressWarnings("deprecation")
	public static void testAdBannerBehavior(WebDriver driver, String browserName) throws InterruptedException {

		// WebDriver driver = new ChromeDriver();

		driver.get("https://rydesharing.com/");

		// Navigate to the website
		driver.get("https://rydesharing.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@data-cky-tag='accept-button']")).click();

		WebElement adBanner = driver.findElement(By.xpath(
				"//div[@class='elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-1535567b']//div[@class='elementor-widget-wrap elementor-element-populated e-swiper-container']"));

		//
		// Verify visibility of the ad banner
		if (adBanner.isDisplayed()) {
			System.out.println("Ad banner is visible for " + browserName);
		} else {
			System.out.println("Ad banner is not visible for " + browserName);
		}

		Thread.sleep(500);

		// Handle ad banner closure (if applicable)
		WebElement closeButton = driver.findElement(By.xpath("//i[@class='eicon-close']"));
		closeButton.click();

		// Thread.sleep(2000);

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
					"//div[@class='elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-1535567b']//div[@class='elementor-widget-wrap elementor-element-populated e-swiper-container']")));

			System.out.println("Ad banner disappears when the 'Close' button is clicked for " + browserName);

		} catch (TimeoutException e) {

			System.out.println("Ad banner did not disappear when the 'Close' button is clicked for " + browserName);

		}

	}
}
