package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Implicitlywaiting {
	public WebDriver driver;
	
	public  Implicitlywaiting(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement waitElement(By locator) {
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(50));
		return wait3.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

}
