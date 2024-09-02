package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.baseMain;
import utilities.Implicitlywaiting;

public class InputSSSValidationMessages {

	 //validation message2
	 String inputSSSM0 = "123";
	 String inputSSSM3 = "";
	 String inputSSSM5 = "";
	 String PageTitle = "Manage Employee";
	
	
	
	 String expectedMessage1 = "The Data you entered contains a letter or special character";
	 String expectedMessage3 = "Employee already exists in Workforce.";
	 String expectedMessage4 = "Hire date/System Date is less than or equal to final process date";
	 String expectedMessage0 = "SSS Nos. Length should be 10 digits.";
	 String inputSSS = "test";

public WebDriver driver;

	public  InputSSSValidationMessages(WebDriver driver) {
		this.driver = driver;
	}
	 Implicitlywaiting waitingElement = new Implicitlywaiting(driver);
	 WebElement title =  waitingElement.waitElement(By.xpath("METextTitle"));
	 String title2 = title.getText();
public void ManageEmployeeTitle() {
	
	
	
	if(PageTitle == title2) {
		
		System.out.println("Page title is: " + title2);
		
	}
	
	   //validation message1
		
	
}
}
