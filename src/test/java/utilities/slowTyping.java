package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//Class Declaration:
public class slowTyping {
	//WebDriver Declaration:
	public WebDriver driver;
	
	//Constructor:
	public  slowTyping(WebDriver driver) {
		this.driver = driver;
	}

	//By locator, Method Declaration:
public void typeText(WebElement element, String text, long delayInMillis) throws InterruptedException {
	//if suing locator
	//WebElement textfields = driver.findElement(locator);
	
	//Method Implementation:
		for (char c : text.toCharArray()) {
			element.sendKeys(String.valueOf(c));
			Thread.sleep(delayInMillis);

		}
		
			
		}
public void clearAndType(WebElement element, String text) throws InterruptedException {
	try {
		// WebElement element = driver.findElement(locator);
		element.clear();
		element.click();
		typeText(element, text, 200);
	} catch (Exception e) {
		e.printStackTrace();
	}

}
}
