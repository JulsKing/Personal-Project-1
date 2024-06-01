package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckingofFields {
	public WebDriver driver;
	
	public CheckingofFields(WebDriver driver) 
	{
		this.driver = driver;
	}
public void PersonalInfoFields(){
	
	//to check if the fields are empty or not
    java.util.List<WebElement> textFields = driver.findElements(By.tagName("input"));
    boolean allFieldsFilled = true;
    // Loop through each text field

    for (WebElement textField : textFields) {
        // Check if the text field is empty
        if (textField.getAttribute("type").equals("text") && textField.getAttribute("value").isEmpty()) {
        	allFieldsFilled = false;
            break;
        }
    }
    if (!allFieldsFilled) {
        // If any text field is empty, print a message and do not proceed
        System.out.println("Some text fields are empty. Please fill them out.");
    } else {
        // If all text fields are filled, proceed to the next page
        // For example, clicking on a button to navigate to the next page
    	driver.findElement(By.xpath("//*[@id=\"$b10\"]/div[3]/a")).click();           
    }
}}
