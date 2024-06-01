package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class slowTyping {
	public WebDriver driver;
	
	public  slowTyping(WebDriver driver) {
		this.driver = driver;
	}
	
	//By locator
public void typeText(WebElement element, String text, long delayInMillis) throws InterruptedException {
	//if suing locator
	//WebElement textfields = driver.findElement(locator);
	

		for (char c : text.toCharArray()) {
			element.sendKeys(String.valueOf(c));
			Thread.sleep(delayInMillis);

		}
			
		}
}
