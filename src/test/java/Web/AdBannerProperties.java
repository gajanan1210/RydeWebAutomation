package Web;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdBannerProperties {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rydesharing.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@data-cky-tag='accept-button']")).click();

		WebElement element = driver.findElement(By.xpath(
				"//div[@class='elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-1535567b']//div[@class='elementor-widget-wrap elementor-element-populated e-swiper-container']"));

		// Locate the banner
		org.openqa.selenium.Point location = element.getLocation();
		System.out.println("Locating the banner with X, Y - coordinates : " + location);

		// Verify if the ad banner is visible and properly loaded

		if (element.isDisplayed()) {
			System.out.println("Ad banner is visible and properly loaded.");
		} else {
			System.out.println("Ad banner is not visible or not properly loaded.");
		}
		Thread.sleep(1000);

		// Scroll the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(1000);

		boolean isBannerVisible = element.isDisplayed();
		boolean isBannerAtBottom = element.getLocation()
				.getY() >= (driver.manage().window().getSize().getHeight() - element.getSize().getHeight());
		if (isBannerVisible && isBannerAtBottom) {
			System.out.println("Ad banner appears fixed at the bottom of the screen while scrolling the page.");
		} else {
			System.out.println("Ad banner does not appear fixed at the bottom of the screen while scrolling the page.");
		}

		/*
		 * // Compare the initial and current positions if (initialY == currentY) {
		 * System.out.
		 * println("Ad banner remains fixed at the bottom of the screen while scrolling the page."
		 * ); } else { System.out.
		 * println("Ad banner does not remain fixed at the bottom of the screen while scrolling the page."
		 * ); }
		 */

		// Verify close button

		WebElement closeButton = driver.findElement(By.xpath("//i[@class='eicon-close']"));
		closeButton.click();

		/*
		 * 
		 * if (element.isDisplayed()) {
		 * 
		 * System.out.
		 * println("Ad banner remains visible after clicking the 'Close' button.");
		 * 
		 * } else {
		 * 
		 * System.out.println("Ad banner disappears when the 'Close' button is clicked."
		 * ); }
		 */
		// Thread.sleep(2000);

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
					"//div[@class='elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-1535567b']//div[@class='elementor-widget-wrap elementor-element-populated e-swiper-container']")));

			System.out.println("Ad banner disappears when the 'Close' button is clicked.");

		} catch (TimeoutException e) {
			// Handle timeout exception if element does not become invisible within the
			// specified timeout
			// For example, log an error message, take a screenshot, or retry the action
			System.out.println("Ad banner did not disappear when the 'Close' button is clicked.");
			// TakeScreenshot.capture(driver, "element_not_invisible");
		}

		/*
		 * 
		 * 
		 * 
		 * WebElement elementAfterClose = driver.findElement(By.xpath(
		 * "//div[@class='elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-1535567b']//div[@class='elementor-widget-wrap elementor-element-populated e-swiper-container']"
		 * ));
		 * 
		 * // Verify if the ad banner disappears after clicking the close button if
		 * (!elementAfterClose.isDisplayed()) {
		 * System.out.println("Ad banner disappears when the 'Close' button is clicked."
		 * ); } else { System.out.
		 * println("Ad banner remains visible after clicking the 'Close' button."); }
		 * 
		 */

		/*
		 * // Verify if the ad banner is no longer visible if (element.isDisplayed()) {
		 * System.out.
		 * println("Ad banner remains visible after clicking the 'Close' button."); }
		 * else {
		 * System.out.println("Ad banner disappears when the 'Close' button is clicked."
		 * ); }
		 */

	}

}
