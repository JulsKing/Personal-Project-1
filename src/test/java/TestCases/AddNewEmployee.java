package TestCases;

import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseMain;
import utilities.slowTyping;
import utilities.CheckingofFields;
import utilities.Gettestdata;

public class AddNewEmployee extends baseMain {
	private slowTyping slowTyping;
	// private CheckingofFields CheckingofFields;

	@Test(priority = 1, dataProviderClass = Gettestdata.class, dataProvider = "inputSSSno")
	public void PersonalInfo(String TitleAbbrv, String FirstName, String MiddleName, String LastName, String BirthDate,
			String SelectLocation, String Nationality, String Citizenship, String Gender, String Expatriate,
			String BloodType, String Religion, String Weight, String HeightFT, String HeightIN,
			String PersonDisabilities, String PersonalEmail, String CivilStatus, String SubstitutedFilling, String TIN,
			String PHIC, String HDMF, String CurrentAddress) throws InterruptedException {


		
		//Dimension newSize = new Dimension(1920, 1080);
		//driver.manage().window().setSize(newSize);
		
		Actions actions = new Actions(driver);

		//Click Hamburger Menu
		WebElement Title = waitElement(By.xpath(loc.getProperty("HamburgerMenu")));
		actions.moveToElement(Title).click().perform();
		//Click Manage Employee
		WebElement ManageEmployee =  waitElement(By.xpath(loc.getProperty("ManageEmlployeeLink")));
		actions.moveToElement(ManageEmployee).click().perform();
		//Click Add New Employee
		waitElement(By.xpath(loc.getProperty("AddNewEmployee"))).click();
		
		//Input SSS number
		WebElement inpustSSS = waitElement(By.xpath(loc.getProperty("InputSSS_textfield")));
		inpustSSS.click();
		inpustSSS.sendKeys("3442528846");

		// click check
		waitElement(By.xpath(loc.getProperty("Check_button"))).click();

		// click Continue
		waitElement(By.xpath(loc.getProperty("Continue"))).click();
		
		
		
		
		
		
		
		//Adding slow typing method
		slowTyping = new slowTyping(driver);

		//CheckingofFields checking2 = new CheckingofFields(driver);
		//checking2.PersonalInfoFields();
		try {
			
			waitElement(By.xpath(loc.getProperty("Title"))).sendKeys(TitleAbbrv);
			
			WebElement firstNameElement = waitElement(By.xpath(loc.getProperty("PI_FirstName")));
	        clearAndType(firstNameElement, FirstName); 
	        WebElement MiddleNameElement = waitElement(By.xpath(loc.getProperty("PI_MiddleName")));
	        clearAndType(MiddleNameElement, MiddleName);
	        WebElement LastNameElement = waitElement(By.xpath(loc.getProperty("PI_LastName")));
	        clearAndType(LastNameElement, LastName);
	        
	        WebElement birthdatePick = driver.findElement(By.xpath(loc.getProperty("PI_Brithdate")));
	        birthdatePick.click();
	        birthdatePick.sendKeys(BirthDate);
	     
	        waitElement (By.xpath(loc.getProperty("PI_SelectPinLoc"))).click();
	        WebElement SelectLocationELement = waitElement(By.xpath(loc.getProperty("PI_EnterLocation")));
	        SelectLocationELement.click();
	        clearAndType(SelectLocationELement, SelectLocation);
	        Thread.sleep(2000);
	       waitElement (By.xpath(loc.getProperty("PI_ClikcPin"))).click();
	        
	       
			
	    	
	        // if using locator not WebElement
			/*clearAndType(By.xpath("//*[@id=\"b9-Input_FirstName\"]"), FirstName);
			clearAndType(By.xpath("//*[@id=\"b9-Input_MiddleName\"]"), MiddleName);
			clearAndType(By.xpath("//*[@id=\"b9-Input_LastName\"]"), LastName);
			clearAndType(By.xpath("//*[@id=\"b9-Input_TextVar2\"]"), SelectLocation); */
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement radioButton = null;
		if (Gender.equalsIgnoreCase("Male")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b9-ButtonGroupItem5\"]"));
			radioButton.click();
		} else if (Gender.equalsIgnoreCase("Female")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b9-ButtonGroupItem6\"]"));
			radioButton.click();
		}

		if (Expatriate.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b9-ButtonGroupItem7\"]"));
			radioButton.click();
		} else if (Expatriate.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b9-ButtonGroupItem8\"]"));
			radioButton.click();

		}
		if (PersonDisabilities.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b9-ButtonGroupItem9\"]"));
			radioButton.click();
		} else if (PersonDisabilities.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b9-ButtonGroupItem10\"]"));
			radioButton.click();

		}
		if (SubstitutedFilling.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b9-ButtonGroupItem13\"]"));
			radioButton.click();
		} else if (SubstitutedFilling.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b9-ButtonGroupItem14\"]"));
			radioButton.click();
		}

try {
	 
     WebElement Nationalitydropdown = driver.findElement(By.xpath(loc.getProperty("PI_Nationality")));
		Select Nationalitydropdown1 = new Select(Nationalitydropdown);
		Nationalitydropdown1.selectByVisibleText(Nationality);
		Thread.sleep(2000);
		
		WebElement Citizenshipdropdown = driver.findElement(By.xpath(loc.getProperty("PI_Citizenship")));
		Select Citizenshipdropdown1 = new Select(Citizenshipdropdown);
		Citizenshipdropdown1.selectByVisibleText(Citizenship);
		Thread.sleep(2000);
		
		WebElement BloodTypedropdown = driver.findElement(By.xpath(loc.getProperty("PI-BloodType")));
		Select BloodTypedropdown1 = new Select(BloodTypedropdown);
		BloodTypedropdown1.selectByVisibleText(BloodType);
		Thread.sleep(2000);


		WebElement Religiondropdown = driver.findElement(By.xpath(loc.getProperty("PI_Religion")));
		Select Religiondropdown1 = new Select(Religiondropdown);
		Religiondropdown1.selectByVisibleText(Religion);
		Thread.sleep(2000);
		
		
		WebElement Weight1 = waitElement(By.xpath(loc.getProperty("PI_Weight")));
		clearAndType(Weight1, Weight);
		
		WebElement HeightFT1 = waitElement(By.xpath(loc.getProperty("PI_HeightFt")));
		clearAndType(HeightFT1, HeightFT);
		
		WebElement HeightIN1 = waitElement(By.xpath(loc.getProperty("PI_HeightIn")));
		clearAndType(HeightIN1, HeightIN);
	
		WebElement PersonalEmail1 = driver.findElement(By.xpath(loc.getProperty("PI_PEmail")));
		clearAndType(PersonalEmail1, PersonalEmail);
		
		WebElement CivilStatus1 = driver.findElement(By.xpath(loc.getProperty("PI_CivilStatus")));
		Select CivilStatus2 = new Select(CivilStatus1);
		CivilStatus2.selectByVisibleText(CivilStatus);
		Thread.sleep(2000);
		
		WebElement TIN1 = driver.findElement(By.xpath("//*[@id=\"b9-Input_TIN\"]"));
		TIN1.sendKeys(TIN);
		Thread.sleep(2000);

		WebElement PHIC1 = driver.findElement(By.xpath("//*[@id=\"b9-Input_PHIC\"]"));
		PHIC1.sendKeys(PHIC);
		Thread.sleep(2000);

		WebElement HDMF1 = driver.findElement(By.xpath("//*[@id=\"b9-Input_HDMF\"]"));
		HDMF1.sendKeys(HDMF);
		Thread.sleep(2000);
}
catch (Exception e) {
	e.printStackTrace();
}

		
		// Scroll down and click next
		// 


		//actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();

WebElement street = driver.findElement(By.xpath("//*[@id=\"b9-Input_FirstName19\"]"));
//street.click();
//street.sendKeys("test");
Thread.sleep(2000);

		WebElement CurrentAddress22 = driver.findElement(By.xpath("//*[@id=\"b9-pinLocation\"]/a/span"));
		CurrentAddress22.click();
		WebElement CurrentAddress2 = driver.findElement(By.xpath("//*[@id=\"b9-Input_TextVar\"]"));
		CurrentAddress2.sendKeys(CurrentAddress);
		Thread.sleep(2000);
		WebElement CurrentAddress2click2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/table/tbody/tr[1]/td[5]/button"));
		CurrentAddress2click2.click();

		
		Thread.sleep(2000);

		//WebElement sameAddress = driver.findElement(By.xpath("//*[@id=\"b9-Checkbox1\"]"));
		//sameAddress.click();
		//Thread.sleep(2000);

		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_UP).perform();

		// Scroll down and click next
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		//actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
		
		
		
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		//actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
		waitElement(By.xpath("//*[@id=\"b9-AddPersonalDetails\"]/div[43]/div[2]/button")).click();
		// add fmaily member
		//wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"$b10\"]/div[3]/a")));

		//waitElement(By.xpath("//*[@id=\"$b10\"]/div[3]/a")).click();
		Thread.sleep(3000);

	}

	//@Test(priority = 2, dataProviderClass = Gettestdata.class, dataProvider = "inputSSSno")

	public void AddFamilyMember(String FirstName, String MiddleName, String LastName, String BirthDate, String Gender,
			String Relationship, String Nationality, String EffectiveDate, String ExpirationDate, String Dependent,
			String Beneficiaries, String Deceased, String IsPWD) throws InterruptedException {

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);

		WebElement FirstName1 = driver.findElement(By.xpath("//*[@id=\"b10-Input_FirstName\"]"));

		FirstName1.clear();
		FirstName1.sendKeys(FirstName);
		Thread.sleep(2000);

		WebElement MiddleName1 = driver.findElement(By.xpath("//*[@id=\"b10-Input_FirstName3\"]"));

		MiddleName1.clear();
		MiddleName1.sendKeys(MiddleName);
		Thread.sleep(2000);

		WebElement LstName1 = driver.findElement(By.xpath("//*[@id=\"b10-Input_FirstName2\"]"));

		LstName1.clear();
		LstName1.sendKeys(LastName);
		Thread.sleep(2000);

		WebElement BirthDate1 = driver.findElement(By.xpath("//*[@id=\"b10-Input_BirthDate_Family\"]"));
		BirthDate1.sendKeys(BirthDate);
		Thread.sleep(2000);

		WebElement Gender1 = driver.findElement(By.xpath("//*[@id=\"b10-Dropdown3\"]"));
		Select GenderSelect = new Select(Gender1);
		GenderSelect.selectByVisibleText(Gender);

		Gender1.sendKeys(Gender);
		Thread.sleep(2000);

		WebElement Relationship1 = driver.findElement(By.xpath("//*[@id=\"b10-Dropdown1\"]"));
		Select RelationshipSelect = new Select(Relationship1);
		RelationshipSelect.selectByVisibleText(Relationship);
		Thread.sleep(2000);

		WebElement Nationality1 = driver.findElement(By.xpath("//*[@id=\"b10-Dropdown2\"]"));

		Select NationalitySelect = new Select(Nationality1);
		NationalitySelect.selectByVisibleText(Nationality);
		Thread.sleep(2000);

		WebElement EffectiveDate1 = driver.findElement(By.xpath("//*[@id=\"b10-input_effectivityDate\"]"));
		EffectiveDate1.sendKeys(EffectiveDate);
		Thread.sleep(2000);

		WebElement ExpirationDate1 = driver.findElement(By.xpath("//*[@id=\"b10-input_effectivityDate2\"]"));
		ExpirationDate1.sendKeys(ExpirationDate);
		Thread.sleep(2000);

		// WebElement Dependent1 =
		// driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroup3\"]"));

		Thread.sleep(2000);

		WebElement radioButton = null;

		if (Dependent.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroupItem5\"]"));
			radioButton.click();
		} else if (Dependent.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroupItem6\"]"));
			radioButton.click();

		} else if (Beneficiaries.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroupItem7\"]"));
			radioButton.click();
		} else if (Beneficiaries.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroupItem8\"]"));
			radioButton.click();
		} else if (Deceased.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroupItem9\"]"));
			radioButton.click();
		} else if (Deceased.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroupItem10\"]"));
			radioButton.click();
		} else if (IsPWD.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroupItem11\"]"));
			radioButton.click();
		} else if (IsPWD.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroupItem12\"]"));
			radioButton.click();
		}

		Thread.sleep(5000);
		// jse.executeScript("arguments[0].click();", button);
		// button.click();

		Thread.sleep(2000);
		// wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"b10-b19-Button\"]")));
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/form/div[16]/div/div/button")).click();

		Thread.sleep(4000);
		if (radioButton != null && !radioButton.isSelected()) {
			radioButton.click();

		}

		WebElement errormessage = driver.findElement(By.xpath("//*[@id=\"b10-Input_FirstName_DescribedBy\"]"));
		errormessage.getText();

		// if(FirstName.isBlank()) {
		// System.out.println("First Name:"+ FirstName);

		// Assert.assertEquals(false, null);
		// }

	}

	
	//Clear and Slow typing
	private void clearAndType(WebElement element, String text) throws InterruptedException {
		try {
			//WebElement element = driver.findElement(locator);
			element.clear();
			slowTyping.typeText(element, text, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	//Waiting of the element
	private WebElement waitElement(By locator) {
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait3.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	}
