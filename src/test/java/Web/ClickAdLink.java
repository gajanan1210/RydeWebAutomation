package Web;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickAdLink {

	public static void main(String[] args) {

		// Initialize ChromeDriver
		WebDriver driver = new ChromeDriver();

		driver.get("https://rydesharing.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@data-cky-tag='accept-button']")).click();

		WebElement adBanner = driver.findElement(By.xpath(
				"//div[@class='elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-1535567b']//div[@class='elementor-widget-wrap elementor-element-populated e-swiper-container']"));

		// Get the window handle of the main window
		String mainWindowHandle = driver.getWindowHandle();

		// Click on the ad banner (opens link in new tab)
		adBanner.click();

		// Switch to the newly opened tab
		String newWindowHandle = waitForNewWindow(driver, mainWindowHandle);

		// Switch to the newly opened tab
		driver.switchTo().window(newWindowHandle);

		// Get the URL of the newly opened tab
		String redirectedURL = driver.getCurrentUrl();

		// Define the expected URL prefix after redirection
		String expectedURLPrefix = "https://rydesharing.com/";

		// Verify if the redirected URL starts with the expected URL prefix
		if (redirectedURL.startsWith(expectedURLPrefix)) {
			System.out
					.println("Clicking on the ad banner redirects to a URL starting with 'https://rydesharing.com/'.");
		} else {
			System.out.println(
					"Clicking on the ad banner does not redirect to a URL starting with 'https://rydesharing.com/'.");
		}

		// Close the newly opened tab
		driver.close();

		// Switch back to the main window
		driver.switchTo().window(mainWindowHandle);

		// Close the browser
		driver.quit();
	}

	// Method to wait for a new window to open and return its handle
	private static String waitForNewWindow(WebDriver driver, String mainWindowHandle) {
		String newWindowHandle = null;
		Set<String> windowHandles = driver.getWindowHandles();

		// Wait until a new window handle is found
		while (windowHandles.size() <= 1) {
			windowHandles = driver.getWindowHandles();
		}

		// Find the new window handle
		for (String handle : windowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				newWindowHandle = handle;
				break;
			}
		}

		return newWindowHandle;
	}
}
