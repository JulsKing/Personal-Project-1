package TestCases;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseMain;
import utilities.Gettestdata;

public class ManageEmployees extends baseMain {
	
	@Test (priority=1)
	
	public void ManageEmployeePage () throws InterruptedException {
		String ExpectedTitle = "Manage Employee";
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		Thread.sleep(4000);
		WebElement HamburgerMenu = driver.findElement(By.xpath(loc.getProperty("HamburgerMenu")));
		HamburgerMenu.click();
		
		Actions a = new Actions(driver);
		a.moveToElement(HamburgerMenu).click();
		
		Thread.sleep(3000);
		WebElement ManageEmployeeLink = driver.findElement(By.xpath(loc.getProperty("ManageEmlployeeLink")));
		ManageEmployeeLink.click();
		Thread.sleep(3000);
		WebElement title = driver.findElement(By.xpath(loc.getProperty("METextTitle")));
		String title2 = title.getText();
		System.out.println("Page title is: " + title2);
		Assert.assertEquals(ExpectedTitle, title2, "Expected title should be:");
		driver.findElement(By.xpath(loc.getProperty("AddNewEmployee"))).click();
		Thread.sleep(3000);
		
	}

	//Prompt message = Data contains special characters
	@Test (priority=2, dataProviderClass=Gettestdata.class, dataProvider = "inputSSSno")
	public void InputSSS_message (String inputSSSnumber) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		String expectedmessage = new String(expectedMessage0);
		String expectedmessage3 = new String(expectedMessage3);
		String expectedmessage4 = new String(expectedMessage4);
		Thread.sleep(2000);
	
		
		WebElement inputSSSnum = driver.findElement(By.xpath(loc.getProperty("InputSSS_textfield")));
		inputSSSnum.sendKeys(inputSSSnumber);
		Thread.sleep(3000);
		WebElement ClickCheck = driver.findElement(By.xpath(loc.getProperty("Check_button")));
		ClickCheck.click();
		Thread.sleep(3000);
		inputSSSnum.clear();
		
		
		boolean validationMessagefound = false;
		long timeout = System.currentTimeMillis()+1000;
		
		while (System.currentTimeMillis() < timeout) {
			try {
				WebElement validationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("PromptMessage"))));
				String messageText = validationMessage.getText();
				
//entered data is less than 9 digits
			if(inputSSSnumber==inputSSSM0) {
				System.out.println("Prompt message 3: " + messageText);
				Assert.assertEquals(messageText, expectedmessage,  "Validation message should be: ");
				validationMessagefound = true;
				
				break;
			}
			
			else if(inputSSSnumber==inputSSSM3) {
				
					System.out.println("Prompt message 3: " + messageText);
					Assert.assertEquals(messageText, expectedmessage3,  "Validation message should be: ");
					validationMessagefound = true;
					
					break;
					
				}
				else if(inputSSSnumber==inputSSSM5) {
					
					System.out.println("Prompt message 3: " + messageText);
					Assert.assertEquals(messageText, expectedmessage4,  "Validation message should be: ");
					validationMessagefound = true;
					//inputSSSnum.clear();
					break;
				}
				
				
			} catch (NoSuchElementException e) {
				
			try {
				Thread.sleep(5000);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
	}
		}
		if(!validationMessagefound) {
	System.out.println("Validation Message not found within the timeout period.");
}
	}


}
			
			
	
		
		

	


	
