package TestCases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.baseMain;

public class AddNewEmployee2 extends baseMain {

	public static void scroll(WebDriver driver, WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	@Test(priority = 1)
	public void manageEmployee() throws InterruptedException {
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		
		Dimension newSize = new Dimension(1920, 1080);
		driver.manage().window().setSize(newSize);
		WebElement HamburgerMenu = driver.findElement(By.xpath(loc.getProperty("HamburgerMenu")));
		HamburgerMenu.click();

		Actions a = new Actions(driver);
		a.moveToElement(HamburgerMenu).click();

		Thread.sleep(3000);
		WebElement ManageEmployeeLink = driver.findElement(By.xpath(loc.getProperty("ManageEmlployeeLink")));
		ManageEmployeeLink.click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("AddNewEmployee"))).click();
		Thread.sleep(3000);

		WebElement inputSSSnum = driver.findElement(By.xpath(loc.getProperty("InputSSS_textfield")));
		inputSSSnum.click();
		inputSSSnum.sendKeys("3442528846");

		Thread.sleep(2000);
		WebElement ClickCheck = driver.findElement(By.xpath(loc.getProperty("Check_button")));
		ClickCheck.click();

		Thread.sleep(2000);
		// click Continue
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]")).click();
		Thread.sleep(3000);

	

		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"b9-AddPersonalDetails\"]/div[43]/div[2]/button")).click();
		// add fmaily member
		Thread.sleep(2000);

		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();

		
		//Thread.sleep(30000);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"$b10\"]/div[3]/a")));

		driver.findElement(By.xpath("//*[@id=\"$b10\"]/div[3]/a")).click();
		//Actions actions = new Actions(driver);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("document.body.style.zoom='90%'");
		//WebElement element = driver.findElement(By.xpath("//*[@id=\"b10-b18-Button\"]/button"));
		
	}
	@Test(priority =2)
	
	public void checkSSS() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));

		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/form/div[16]/div/div/button"));
		wait2.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
		Thread.sleep(2000);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//Thread.sleep(2000);

		//scroll(driver, element);
		//element.click();

		boolean element2 = false;
		
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/form/div[16]/div/div/button")).click();
			element2 = true;
			
		}
		catch (NoSuchElementException e) {
			
			try {
				Thread.sleep(5000);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		
		if (!element2) {
			System.out.println("Not able to see the save button");
		}
		
		
		
		// actions.click(element);

		// Point location = element.getLocation();
		// Dimension size = element.getSize();
		// int xOffset = Math.max(0,
		// Math.min(location.getX(),driver.manage().window().getSize().getWidth()));
		// int yOffset = Math.max(0,
		// Math.min(location.getY(),driver.manage().window().getSize().getHeight()));

		// actions.moveByOffset(1221,690).click().build().perform();
		// actions.moveToElement(element, xOffset, yOffset).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.id("b10-b19-Button")).click();
	}

}
	}
