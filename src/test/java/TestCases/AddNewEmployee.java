package TestCases;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
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
import utilities.Implicitlywaiting;

public class AddNewEmployee extends baseMain {
	slowTyping typing = new slowTyping(driver);
	Implicitlywaiting waitingElement = new Implicitlywaiting(driver);

	
@Test(priority = 1, dataProviderClass = Gettestdata.class, dataProvider = "inputSSSno")
	public void PersonalInfo(String TitleAbbrv, String FirstName, String MiddleName, String LastName, String BirthDate,
			String SelectLocation, String Nationality, String Citizenship, String Gender, String Expatriate,
			String BloodType, String Religion, String Weight, String HeightFT, String HeightIN,
			String PersonDisabilities, String PersonalEmail, String CivilStatus, String SubstitutedFilling, String TIN,
			String PHIC, String HDMF, String CurrentAddress) throws InterruptedException {

		// Dimension newSize = new Dimension(1920, 1080);
		// driver.manage().window().setSize(newSize);
	
		Actions actions = new Actions(driver);
		//watingElement = new Implicitlywaiting(driver);
		// Click Hamburger Menu
		WebElement Title = waitingElement.waitElement(By.xpath(loc.getProperty("HamburgerMenu")));
		actions.moveToElement(Title).click().perform();
		// Click Manage Employee
		WebElement ManageEmployee = waitingElement.waitElement(By.xpath(loc.getProperty("ManageEmlployeeLink")));
		actions.moveToElement(ManageEmployee).click().perform();
		// Click Add New Employee
		waitingElement.waitElement(By.xpath(loc.getProperty("AddNewEmployee"))).click();

		// Input SSS number
		WebElement inpustSSS = waitingElement.waitElement(By.xpath(loc.getProperty("InputSSS_textfield")));
		inpustSSS.click();
		inpustSSS.sendKeys("3442528846");

		// click check
		waitingElement.waitElement(By.xpath(loc.getProperty("Check_button"))).click();

		// click Continue
		waitingElement.waitElement(By.xpath(loc.getProperty("Continue"))).click();
		Thread.sleep(2000);


		// Personal Info
		try {

			waitingElement.waitElement(By.xpath(loc.getProperty("Title"))).sendKeys(TitleAbbrv);

			WebElement firstNameElement = waitingElement.waitElement(By.xpath(loc.getProperty("PI_FirstName")));
			typing.clearAndType(firstNameElement, FirstName);
			WebElement MiddleNameElement = waitingElement.waitElement(By.xpath(loc.getProperty("PI_MiddleName")));
			typing.clearAndType(MiddleNameElement, MiddleName);
			WebElement LastNameElement = waitingElement.waitElement(By.xpath(loc.getProperty("PI_LastName")));
			typing.clearAndType(LastNameElement, LastName);

			WebElement birthdatePick = driver.findElement(By.xpath(loc.getProperty("PI_Brithdate")));
			birthdatePick.click();
			birthdatePick.sendKeys(BirthDate);

			waitingElement.waitElement(By.xpath(loc.getProperty("PI_SelectPinLoc"))).click();
			WebElement SelectLocationELement = waitingElement.waitElement(By.xpath(loc.getProperty("PI_EnterLocation")));
			SelectLocationELement.click();
			typing.clearAndType(SelectLocationELement, SelectLocation);
			Thread.sleep(2000);
			waitingElement.waitElement(By.xpath(loc.getProperty("PI_ClikcPin"))).click();

			// if using locator not WebElement
			/*
			 * clearAndType(By.xpath("//*[@id=\"b9-Input_FirstName\"]"), FirstName);
			 * clearAndType(By.xpath("//*[@id=\"b9-Input_MiddleName\"]"), MiddleName);
			 * clearAndType(By.xpath("//*[@id=\"b9-Input_LastName\"]"), LastName);
			 * clearAndType(By.xpath("//*[@id=\"b9-Input_TextVar2\"]"), SelectLocation);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement radioButton = null;
		if (Gender.equalsIgnoreCase("Male")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("RB_GenderM")));
			radioButton.click();
		} else if (Gender.equalsIgnoreCase("Female")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("RB_GenderF")));
			radioButton.click();
		}

		if (Expatriate.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("Expatriate_Y")));
			radioButton.click();
		} else if (Expatriate.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("Expatriate_N")));
			radioButton.click();

		}
		if (PersonDisabilities.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("Disabilities_Y")));
			radioButton.click();
		} else if (PersonDisabilities.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("Disabilities_N")));
			radioButton.click();

		}
		if (SubstitutedFilling.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("Substitute_Y")));
			radioButton.click();
		} else if (SubstitutedFilling.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("Substitute_N")));
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

			WebElement Weight1 = waitingElement.waitElement(By.xpath(loc.getProperty("PI_Weight")));
			typing.clearAndType(Weight1, Weight);

			WebElement HeightFT1 = waitingElement.waitElement(By.xpath(loc.getProperty("PI_HeightFt")));
			typing.clearAndType(HeightFT1, HeightFT);

			WebElement HeightIN1 = waitingElement.waitElement(By.xpath(loc.getProperty("PI_HeightIn")));
			typing.clearAndType(HeightIN1, HeightIN);

			WebElement PersonalEmail1 = driver.findElement(By.xpath(loc.getProperty("PI_PEmail")));
			typing.clearAndType(PersonalEmail1, PersonalEmail);

			WebElement CivilStatus1 = driver.findElement(By.xpath(loc.getProperty("PI_CivilStatus")));
			Select CivilStatus2 = new Select(CivilStatus1);
			CivilStatus2.selectByVisibleText(CivilStatus);
			Thread.sleep(2000);

			WebElement TIN1 = waitingElement.waitElement(By.xpath(loc.getProperty("TIN")));
			typing.clearAndType(TIN1, TIN);

			WebElement PHIC1 = waitingElement.waitElement(By.xpath(loc.getProperty("PHIC")));
			typing.clearAndType(PHIC1, PHIC);

			WebElement HDMF1 = waitingElement.waitElement(By.xpath(loc.getProperty("HDMF")));
			typing.clearAndType(HDMF1, HDMF);

		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement CurrentAddress22 = driver.findElement(By.xpath(loc.getProperty("PI_SelectPINLoc2")));
		CurrentAddress22.click();
		WebElement CurrentAddress2 = driver.findElement(By.xpath(loc.getProperty("PI_SelectPINLoc2TF")));
		CurrentAddress2.sendKeys(CurrentAddress);
		Thread.sleep(2000);
		WebElement CurrentAddress2click2 = driver.findElement(By.xpath(loc.getProperty("PI_SelectPINLoc2Button")));
		CurrentAddress2click2.click();

		WebElement street = driver.findElement(By.xpath(loc.getProperty("Street_TF")));

		street.clear();
		street.sendKeys("test");

		Thread.sleep(2000);
//Click Next
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		waitingElement.waitElement(By.xpath("//*[@id=\"b9-AddPersonalDetails\"]/div[42]/div[2]/button")).click();

		Thread.sleep(3000);

	}

@Test(priority = 2, dataProviderClass = Gettestdata.class, dataProvider = "inputSSSno")

	public void AddFamilyMember(String FirstName, String MiddleName, String LastName, String BirthDate, String Gender,
			String Relationship, String Nationality, String EffectiveDate, String ExpirationDate, String Dependent,
			String Beneficiaries, String Deceased, String IsPWD) throws InterruptedException {
	
		Actions actions = new Actions(driver);
		// add family member
		waitingElement.waitElement(By.xpath(loc.getProperty("AddFamilyButton"))).click();

		WebElement FirstName1 = waitingElement.waitElement(By.xpath(loc.getProperty("FirstName")));
		typing.clearAndType(FirstName1, FirstName);

		WebElement MiddleName1 = waitingElement.waitElement(By.xpath(loc.getProperty("MiddleName")));
		typing.clearAndType(MiddleName1, MiddleName);

		WebElement LstName1 = waitingElement.waitElement(By.xpath(loc.getProperty("LastName")));
		typing.clearAndType(LstName1, LastName);

		WebElement BirthDate1 = driver.findElement(By.xpath(loc.getProperty("BirthDate")));
		BirthDate1.sendKeys(BirthDate);

		WebElement Gender1 = waitingElement.waitElement(By.xpath(loc.getProperty("Gender")));
		Gender1.click();
		Select GenderSelect = new Select(Gender1);
		GenderSelect.selectByVisibleText(Gender);

		WebElement Relationship1 = waitingElement.waitElement(By.xpath(loc.getProperty("Relationship")));
		Relationship1.click();
		Select RelationshipSelect = new Select(Relationship1);
		RelationshipSelect.selectByVisibleText(Relationship);
		Thread.sleep(2000);

		WebElement Nationality1 = waitingElement.waitElement(By.xpath(loc.getProperty("Nationality")));
		Nationality1.click();
		Select NationalitySelect = new Select(Nationality1);
		NationalitySelect.selectByVisibleText(Nationality);

		WebElement EffectiveDate1 = driver.findElement(By.xpath(loc.getProperty("EffectiveDate")));
		EffectiveDate1.sendKeys(EffectiveDate);
		Thread.sleep(2000);

		WebElement ExpirationDate1 = driver.findElement(By.xpath(loc.getProperty("ExpirationDate")));
		ExpirationDate1.sendKeys(ExpirationDate);

		// WebElement Dependent1 =
		// driver.findElement(By.xpath("//*[@id=\"b10-ButtonGroup3\"]"));

		Thread.sleep(2000);

		WebElement radioButton = null;

		if (Dependent.equalsIgnoreCase("Yes")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("Dependent_Y")));
			radioButton.click();
		} else if (Dependent.equalsIgnoreCase("No")) {
			radioButton = driver.findElement(By.xpath(loc.getProperty("Dependent_N")));
			radioButton.click();

		}
		if (Beneficiaries.equalsIgnoreCase("Yes")) {
			radioButton = waitingElement.waitElement(By.xpath(loc.getProperty("Benefeciaries_Y")));
			radioButton.click();
		} else if (Beneficiaries.equalsIgnoreCase("No")) {
			radioButton = waitingElement.waitElement(By.xpath(loc.getProperty("Benefeciaries_N")));
			radioButton.click();
		}
		if (Deceased.equalsIgnoreCase("Yes")) {
			radioButton = waitingElement.waitElement(By.xpath(loc.getProperty("Deceased_Y")));
			radioButton.click();
		} else if (Deceased.equalsIgnoreCase("No")) {
			radioButton = waitingElement.waitElement(By.xpath(loc.getProperty("Deceased_N")));
			radioButton.click();
		}
		if (IsPWD.equalsIgnoreCase("Yes")) {
			radioButton = waitingElement.waitElement(By.xpath(loc.getProperty("PWD_Y")));
			radioButton.click();
		} else if (IsPWD.equalsIgnoreCase("No")) {
			radioButton = waitingElement.waitElement(By.xpath(loc.getProperty("PWD_N")));
			radioButton.click();
		}

		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		// wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"b10-b19-Button\"]")));
		waitingElement.waitElement(By.xpath(loc.getProperty("AddButton"))).click();
		Thread.sleep(2000);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		waitingElement.waitElement(By.xpath(loc.getProperty("Next_button"))).click();

		Thread.sleep(2000);
	}

	@Test(priority = 3, dataProviderClass = Gettestdata.class, dataProvider = "inputSSSno")
	public void Employment(String Company, String Branch, String Division, String Department, String WorkType,
			String EmploymentStartDate, String WorkEmailAddress, String Position)
			throws InterruptedException {
		
		Actions actions = new Actions(driver);
		//slowTyping = new slowTyping(driver);
		//Implicitlywaiting = new waitElement(driver);
		
		// Click Hamburger Menu
		/*WebElement Title = waitingElement.waitElement(By.xpath(loc.getProperty("HamburgerMenu")));
		actions.moveToElement(Title).click().perform();
		// Click Manage Employee
		WebElement ManageEmployee = waitingElement.waitElement(By.xpath(loc.getProperty("ManageEmlployeeLink")));
		actions.moveToElement(ManageEmployee).click().perform();
		// Click Add New Employee
		waitingElement.waitElement(By.xpath(loc.getProperty("AddNewEmployee"))).click();

		// Input SSS number
		WebElement inpustSSS = waitingElement.waitElement(By.xpath(loc.getProperty("InputSSS_textfield")));
		inpustSSS.click();
		inpustSSS.sendKeys("3442528846");

		// click check
		waitingElement.waitElement(By.xpath(loc.getProperty("Check_button"))).click();

		// click Continue
		waitingElement.waitElement(By.xpath(loc.getProperty("Continue"))).click();
		Thread.sleep(2000);

		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		waitingElement.waitElement(By.xpath("//*[@id=\"b9-AddPersonalDetails\"]/div[42]/div[2]/button")).click();

		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		waitingElement.waitElement(By.xpath(loc.getProperty("Next_button"))).click();
*/
		Thread.sleep(2000);
		List<WebElement> lists = driver.findElements(By.xpath(loc.getProperty("searchInput")));
		for (int i = 0; i < lists.size(); i++) {
			WebElement searhfields = lists.get(i);
			String id = searhfields.getAttribute("id");
			String placeholder = searhfields.getAttribute("placeholder");
			System.out.println("Search Fields:" + (i + 1) + "id = " + id + "placeholder=" + placeholder);
		}
		List<WebElement> Results = driver.findElements(By.xpath(loc.getProperty("selectResults")));
		for (int i = 0; i < Results.size(); i++) {
			WebElement selectResults = Results.get(i);
			String id = selectResults.getAttribute("id");
			String tooltip = selectResults.getAttribute("data-tooltip");
			System.out.println("Search Fields:" + (i + 1) + "id = " + id + "data-tooltip=" + tooltip);
		}

		waitingElement.waitElement(By.xpath(loc.getProperty("Emp_Company"))).click();
		WebElement EnterComp = waitingElement.waitElement(By.xpath(loc.getProperty("Enter_Comp")));
		EnterComp.sendKeys(Company);
		EnterComp.sendKeys(Keys.RETURN);

		// waitElement (By.xpath(loc.getProperty("Select_Company"))).click();

		Thread.sleep(3000);
		waitingElement.waitElement(By.xpath(loc.getProperty("Emp_Branch"))).click();
		WebElement EnterBranch = waitingElement.waitElement(By.xpath(loc.getProperty("Enter_Branch")));
		EnterBranch.sendKeys(Branch);
		EnterBranch.sendKeys(Keys.RETURN);

		Thread.sleep(3000);
		waitingElement.waitElement(By.xpath(loc.getProperty("Emp_Division"))).click();
		WebElement EnterDivision = waitingElement.waitElement(By.xpath(loc.getProperty("Enter_Division")));
		EnterDivision.sendKeys(Division);
		EnterDivision.sendKeys(Keys.RETURN);

		Thread.sleep(3000);
		waitingElement.waitElement(By.xpath(loc.getProperty("Emp_Department"))).click();
		Thread.sleep(5000);
		WebElement EnterDpt = waitingElement.waitElement(By.xpath(loc.getProperty("Enter_Dpt")));
		EnterDpt.sendKeys(Department);
		EnterDpt.sendKeys(Keys.RETURN);

		Thread.sleep(3000);
		waitingElement.waitElement(By.xpath(loc.getProperty("Emp_Work_Type"))).click();
		WebElement EnterWorkType = waitingElement.waitElement(By.xpath(loc.getProperty("Enter_WorkType")));
		EnterWorkType.sendKeys(WorkType);
		EnterWorkType.sendKeys(Keys.RETURN);

		Thread.sleep(3000);
		WebElement Employment_Start_Date1 = driver.findElement(By.xpath(loc.getProperty("Emp_Employment_Start_Date")));
		Employment_Start_Date1.sendKeys(EmploymentStartDate);

		Thread.sleep(3000);
		WebElement Work_Email_Add1 = waitingElement.waitElement(By.xpath(loc.getProperty("Emp_Work_Email_Address")));
		Work_Email_Add1.sendKeys(WorkEmailAddress);
		Work_Email_Add1.sendKeys(Keys.RETURN);
		
	

		Thread.sleep(3000);
		WebElement Position1 = waitingElement.waitElement(By.xpath(loc.getProperty("Emp_Position")));
		actions.moveToElement(Position1).click().perform();
		Thread.sleep(8000);
		WebElement EnterPosition = waitingElement.waitElement(By.xpath(loc.getProperty("Enter_Position")));
		EnterPosition.sendKeys(Position);
		EnterPosition.sendKeys(Keys.RETURN);

		//driver.switchTo().defaultContent();
		
	
		
	
		
	

		Thread.sleep(3000);
		//WebElement Effective_Date1 = driver.findElement(By.xpath(loc.getProperty("Emp_Effective_Date")));
		//Effective_Date1.sendKeys("Effective_Date");

		//WebElement Enter_LN1 = waitElement(By.xpath(loc.getProperty("Emp_LastName2")));
		//Enter_LN1.sendKeys("King");

	//	waitElement(By.xpath(loc.getProperty("Emp_Search_btn"))).click();
		//waitElement(By.xpath(loc.getProperty("Emp_Add"))).click();
		//waitElement(By.xpath(loc.getProperty("Emp_Close"))).click();
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		waitingElement.waitElement(By.xpath(loc.getProperty("Emp_Next"))).click();

	}
}
