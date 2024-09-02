package TestCases;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseMain;

public class Dashboard extends baseMain {

	


	@Test(priority = 0)

	public void HR_Logins() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		driver.findElement(By.id("Input_UsernameVal")).sendKeys("");
		// Thread.sleep(10000);
		driver.findElement(By.id("Input_PasswordVal")).sendKeys("");
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/form/div[2]/div/div/button")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'Workforce')]")).click();

		// File screenshotFile = ((TakesScreenshot)
		// driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(screenshotFile, new File(".//screenshot/screen.png"));

	}
	// Check if all "Text contents" are available

	@Test(priority = 1)
	public void ContentNames() throws InterruptedException {
		Thread.sleep(5000);

		String ExpCName1 = "Active Employee";
		String ActCName1 = driver.findElement(By.xpath("//span[@class='muted'][normalize-space()='Active Employee']"))
				.getText();
		String ExpCName2 = "New Employee";
		String ActCName2 = driver.findElement(By.xpath("//span[normalize-space()='New Employee']")).getText();
		String ExpCName3 = "Probationary and Seasonal Employee";
		String ActCName3 = driver
				.findElement(By.xpath("//span[normalize-space()='Probationary and Seasonal Employee']")).getText();
		String ExpCName4 = "Resigned Employee";
		String ActCName4 = driver.findElement(By.xpath("//span[normalize-space()='Resigned Employee']")).getText();

		Assert.assertEquals(ActCName1, ExpCName1, "Verify Menu Item 1");
		Assert.assertEquals(ActCName2, ExpCName2, "Verify Menu Item 2");
		Assert.assertEquals(ActCName3, ExpCName3, "Verify Menu Item 3");
		Assert.assertEquals(ActCName4, ExpCName4, "Verify Menu Item 4");

		System.out.println("Section 1 " + ActCName1);
		System.out.println("Section 2 " + ActCName2);
		System.out.println("Section 3 " + ActCName3);
		System.out.println("Section 4 " + ActCName4);

		Thread.sleep(2000);
		// driver.navigate().refresh();
		// Thread.sleep(5000);

		// driver.findElement(By.xpath("//span[@class='muted'][normalize-space()='Active
		// Employee']"));

	}

//@Test(priority=2)

	// Check if "view details" link text is clickable
	public void ClickableMenus() throws InterruptedException {
		// Click Active Employee

		String ViewDetail1 = "Active Employee";
		driver.findElement(By.xpath("//*[@id=\"b4-Content\"]/div[4]/a")).click();
		WebElement Element1 = driver.findElement(By.xpath("//*[@id=\"b3-Column2\"]/div[1]/label/span"));
		String ActMenu1 = Element1.getText();

		Assert.assertEquals(ActMenu1, ViewDetail1, "Menu 1 should be:");
		Thread.sleep(1000);

		// Click New Employee
		String ViewDetail2 = "New Employee for the Current Cut-Off";
		driver.findElement(By.xpath("//*[@id=\"b6-Content\"]/div[4]/a")).click();
		WebElement Element2 = driver.findElement(By.xpath("//*[@id=\"b3-Column2\"]/div[1]/label/span"));
		String ActMenu2 = Element2.getText();

		Assert.assertEquals(ActMenu2, ViewDetail2, "Menu 2 should be:");
		Thread.sleep(1000);

		// Click Probationary and seasonal Employee
		String ViewDetail3 = "Probationary and Seasonal Employee Active";
		driver.findElement(By.xpath("//*[@id=\"b8-Content\"]/div[4]/a")).click();
		WebElement Element3 = driver.findElement(By.xpath("//*[@id=\"b3-Column2\"]/div[1]/label/span"));
		String ActMenu3 = Element3.getText();

		Assert.assertEquals(ActMenu3, ViewDetail3, "Menu 3 should be:");
		Thread.sleep(1000);

		// Click Resigned Employee for the Fiscal Year
		String ViewDetail4 = "Resigned Employee for the Fiscal Year";
		driver.findElement(By.xpath("//*[@id=\"b10-Content\"]/div[4]/a")).click();
		WebElement Element4 = driver.findElement(By.xpath("//*[@id=\"b3-Column2\"]/div[1]/label/span"));
		String ActMenu4 = Element4.getText();

		Assert.assertEquals(ActMenu4, ViewDetail4, "Menu 4 should be:");

//driver.navigate().refresh();
		Thread.sleep(2000);
		// driver.navigate().back();
		// WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Workforce')]")));
		//

		// Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void ActiveEmployeeCount() throws InterruptedException {
// Wait for Active employee count to be visible
		// driver.navigate().refresh();
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// WebElement rowtext =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)")));
		// rowtext.getText();

		// driver.findElement(By.xpath("//*[@id=\"b4-Content\"]/div[4]/a")).click();

		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("#b3-Column2>div>table>tbody>tr>td:nth-child(3)")));

		Thread.sleep(3000);
//driver.findElement(By.xpath("//*[@id=\"b10-Content\"]/div[4]/a")).click();

//Thread.sleep(4000);
		String AcEmployeeCount = driver.findElement(By.xpath("//*[@id=\"cardContext1\"]/span[2]/label/span")).getText();

		int sum = 0;

		while (true) {
			Thread.sleep(2000);

			WebElement table = driver.findElement(By.cssSelector("#b3-Column2>div>table"));
			java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
			for (int i = 1; i < rows.size(); i++) {
//for(WebElement rows : table){
// Locate the column with the amount in each row
				WebElement amountColumn = rows.get(i)
						.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));

// Extract the text from the amount column and convert it to double
//double amount = Double.parseDouble(amountColumn.getText());
				int amount = Integer.parseInt(amountColumn.getText());
				Thread.sleep(2000);
// Add the amount to the sum
				sum += amount;
			}
			if (driver.findElements(By.xpath("//*[@id=\"IsTableLoadingOrEmpty\"]")).isEmpty()) {
				driver.findElement(By.xpath("//*[@id=\"cardContext3\"]/span[2]/label/span")).getText();
//Assert.assertEquals(sum, NewEmployeeCount);
				System.out.println("Sum of values in the column: " + sum);
				Assert.assertEquals(sum, AcEmployeeCount, "Prob  count should be:");
				break;
			}
			if (driver.findElements(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)")).isEmpty()) {

				break;
			}

// WebElement nextpage = driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)"));
			else if (driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)"))
					.isEnabled() == true) {
// nextpage.click();
				driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)")).click();

			} else {
				break;
			}
		}
		Thread.sleep(2000);
		System.out.println("Sum of Active employees: " + sum);
		Assert.assertEquals(String.valueOf(sum), AcEmployeeCount, "Prob Emmployee count should be:");
	}

	@Test(priority = 4)
	public void NewEmployeeCount() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"b6-Content\"]/div[4]/a")).click();

//Thread.sleep(3000);
		String NewEmployeeCount = driver.findElement(By.xpath("//*[@id=\"cardContext2\"]/span[2]/label/span"))
				.getText();

		int sum = 0;

		while (true) {

			Thread.sleep(2000);
			WebElement table = driver.findElement(By.cssSelector("#b3-Column2>div>table"));
			java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
			for (int i = 1; i < rows.size(); i++) {
				// for(WebElement rows : table){
				// Locate the column with the amount in each row
				WebElement amountColumn = rows.get(i)
						.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));

				// Extract the text from the amount column and convert it to double
				// double amount = Double.parseDouble(amountColumn.getText());
				int amount = Integer.parseInt(amountColumn.getText());
				Thread.sleep(2000);
				// Add the amount to the sum
				sum += amount;
			}
			if (driver.findElements(By.xpath("//*[@id=\"IsTableLoadingOrEmpty\"]")).isEmpty()) {
				driver.findElement(By.xpath("//*[@id=\"cardContext2\"]/span[2]/label/span")).getText();
				// Assert.assertEquals(sum, NewEmployeeCount);
				System.out.println("Sum of values in the column: " + sum);
				Assert.assertEquals(String.valueOf(sum), NewEmployeeCount, "New  count should be:");
				break;
			}
			if (driver.findElements(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)")).isEmpty()) {

				break;
			}

			// WebElement nextpage =
			// driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav >
			// button:nth-child(3)"));
			else if (driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)"))
					.isEnabled() == true) {
				// nextpage.click();
				driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)")).click();
			} else {
				break;
			}

		}
		Thread.sleep(2000);

		System.out.println("Sum of New Employees: " + sum);
		Assert.assertEquals(String.valueOf(sum), NewEmployeeCount, "New Emmployee count should be:");

	}

	@Test(priority = 5)
	public void ResignedEmployeeCount() throws InterruptedException {

		Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(By.xpath("//span[contains(text(),'Workforce')]")).click();
		Thread.sleep(2000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// WebElement rowtest2 =
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[@id=\"b10-Content\"]/div[4]/a")));
		// wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(rowtest2)));
		// rowtest2.click();
		driver.findElement(By.xpath("//*[@id=\"b10-Content\"]/div[4]/a")).click();
//	WebElement rowtext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/*[@id=\"b10-Content\"]/div[4]/a")));
		// rowtext.click();

		// Thread.sleep(4000);
		String ResEmployeeCount = driver.findElement(By.xpath("//*[@id=\"cardContext4\"]/span[2]/label/span"))
				.getText();

		int sum = 0;

		while (true) {
			Thread.sleep(2000);

			WebElement table = driver.findElement(By.cssSelector("#b3-Column2>div>table"));
			java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
			for (int i = 1; i < rows.size(); i++) {
				// for(WebElement rows : table){
				// Locate the column with the amount in each row
				WebElement amountColumn = rows.get(i)
						.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));

				// Extract the text from the amount column and convert it to double
				// double amount = Double.parseDouble(amountColumn.getText());
				int amount = Integer.parseInt(amountColumn.getText());
				Thread.sleep(2000);
				// Add the amount to the sum
				sum += amount;
			}
			if (driver.findElements(By.xpath("//*[@id=\"IsTableLoadingOrEmpty\"]")).isEmpty()) {
				driver.findElement(By.xpath("//*[@id=\"cardContext3\"]/span[2]/label/span")).getText();
				// Assert.assertEquals(sum, NewEmployeeCount);
				System.out.println("Sum of values in the column: " + sum);
				Assert.assertEquals(sum, ResEmployeeCount, "Prob  count should be:");
				break;
			}
			if (driver.findElements(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)")).isEmpty()) {

				break;
			}

			// WebElement nextpage =
			// driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav >
			// button:nth-child(3)"));
			else if (driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)"))
					.isEnabled() == true) {
				// nextpage.click();
				driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)")).click();

			} else {
				break;
			}
		}
		Thread.sleep(2000);
		System.out.println("Sum of Resigned employees: " + sum);
		Assert.assertEquals(String.valueOf(sum), ResEmployeeCount, "Prob Emmployee count should be:");
	}

	@Test(priority = 6)
	public void ProbEmployeeCount() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"b8-Content\"]/div[4]/a")).click();

//Thread.sleep(4000);
		String ProbEmployeeCount = driver.findElement(By.xpath("//*[@id=\"cardContext3\"]/span[2]/label/span"))
				.getText();

		int sum = 0;

		while (true) {
			Thread.sleep(2000);

			WebElement table = driver.findElement(By.cssSelector("#b3-Column2>div>table"));
			java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
			for (int i = 1; i < rows.size(); i++) {
//for(WebElement rows : table){
// Locate the column with the amount in each row
				WebElement amountColumn = rows.get(i)
						.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));

// Extract the text from the amount column and convert it to double
//double amount = Double.parseDouble(amountColumn.getText());
				int amount = Integer.parseInt(amountColumn.getText());
				Thread.sleep(2000);
// Add the amount to the sum
				sum += amount;
			}
			if (driver.findElements(By.xpath("//*[@id=\"IsTableLoadingOrEmpty\"]")).isEmpty()) {
				driver.findElement(By.xpath("//*[@id=\"cardContext3\"]/span[2]/label/span")).getText();
//Assert.assertEquals(sum, NewEmployeeCount);
				System.out.println("Sum of values in the column: " + sum);
				Assert.assertEquals(sum, ProbEmployeeCount, "Prob  count should be:");
				break;
			}
			if (driver.findElements(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)")).isEmpty()) {

				break;
			}

// WebElement nextpage = driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)"));
			else if (driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)"))
					.isEnabled() == true) {
// nextpage.click();
				driver.findElement(By.cssSelector("#b13-PaginationWrapper > nav > button:nth-child(3)")).click();

			} else {
				break;
			}
		}
		Thread.sleep(2000);
		System.out.println("Sum of probationary employees is: " + sum);
		Assert.assertEquals(String.valueOf(sum), ProbEmployeeCount, "Prob Emmployee count should be:");

	}

//Searching validation (Active Employee)
@Test(priority = 7)

public void SearchingwithResultActiveEmployee () throws InterruptedException {
	driver.navigate().back();
	driver.findElement(By.xpath("//span[contains(text(),'Workforce')]")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"b4-Content\"]/div[4]/a")).click();
	
	//Enter Search in the field
	 WebElement SearchKey = driver.findElement(By.id("Input_SearchVar"));
	
	SearchKey.click();
	SearchKey.sendKeys("SHOEMART, INC.");
	String ExpResult1 = SearchKey.getAttribute("value");
	Thread.sleep(2000);

	List <WebElement> NameElement = driver.findElements(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)"));
	List<String> AllResult = new ArrayList <String>();
	
	for(WebElement Element1 : NameElement) {
		
	AllResult.add(Element1.getText());	
	}
	
	for (String ResultValidation : AllResult) {
		System.out.println("Result are: " + ResultValidation);
	
		if(ResultValidation == ExpResult1) {
	Assert.assertEquals(ResultValidation, ExpResult1, "Result should be: ");
	
	
	}
	}
	
	SearchKey.click();
	SearchKey.clear();
	SearchKey.sendKeys("test");
	Thread.sleep(2000);
	
	//driver.navigate().refresh();
	
	WebElement ActResult2 = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));
	int amount = Integer.parseInt(ActResult2.getText());		
	int displayResult = 0;
	
	if (amount == displayResult) {
		System.out.print("Result is:" + amount);
		Assert.assertEquals(amount, displayResult, "Count should be:");
		
	
	}
	}
	//@Test(priority = 8)

	public void SearchingwithnoResult() throws InterruptedException {
		
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"b4-Content\"]/div[4]/a")).click();
		 WebElement SearchKey = driver.findElement(By.id("Input_SearchVar"));

		SearchKey.click();
		SearchKey.clear();
		SearchKey.sendKeys("Short");
		
		WebElement ActResult2 = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));

		int amount = Integer.parseInt(ActResult2.getText());
		int displayResult = 0;

		if (amount == displayResult) {
			System.out.print("Result is:" + amount);
			Assert.assertEquals(amount, displayResult, "Count should be:");

		}

	}

	//Searching validation (New Employee)
	//@Test(priority = 9)

	public void SearchingwithResultNewEmployee () throws InterruptedException {
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"b6-Content\"]/div[4]/a")).click();
		
		 WebElement SearchKey = driver.findElement(By.id("Input_SearchVar"));

		SearchKey.click();
		SearchKey.clear();
		//driver.findElement(By.cssSelector("#b3-Column2 > div.table-container"));
		SearchKey.click();
		SearchKey.sendKeys("SHOEMART, INC.");
		
		Thread.sleep(2000);
		//Result validation
		
		//WebElement ExpResult = driver.findElement(By.id("Input_SearchVar"));
		String ExpResult1 = SearchKey.getAttribute("value");
		
		
		
		
		//WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
	   //	wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("#b3-Column2>div>table>tbody>tr>td:nth-child(1)")));
		Thread.sleep(2000);
		//WebElement ActResult = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)"));
		//ActResult.getText();
		
		//WebElement table = driver.findElement(By.cssSelector("#b3-Column2>div>table"));
		//java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		List<String> AllResult = new ArrayList <String>();

		
		//List<String> ActResult = new ArrayList <String>();
		//Thread.sleep(4000);

		List<WebElement> NameElement = driver.findElements(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)"));

		
			for (WebElement Result : NameElement) {
				AllResult.add(Result.getText());
			}
		for (String displayResult : AllResult) {
			
			//driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)")).getText();
			
				
			System.out.println ("Showing resut " + displayResult);
			//Assert.assertEquals(ExpResult, displayResult, "Search Result should be:");
			
			
		if (displayResult == ExpResult1) {
			
			Assert.assertEquals(displayResult, ExpResult1, "Search Result should be:");
		}
		}
		Thread.sleep(2000);
		driver.findElement(By.id("Input_SearchVar")).click();
		driver.findElement(By.id("Input_SearchVar")).clear();
		driver.findElement(By.id("Input_SearchVar")).sendKeys("Short");
		WebElement ActResult2 = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));
		int amount = Integer.parseInt(ActResult2.getText());		
		int displayResult = 0;
		
		if (amount == displayResult) {
			System.out.print("Result is:" + amount);
			Assert.assertEquals(amount, displayResult, "Count should be:");
			
		}
		}

		//@Test(priority = 10)

		public void SearchingwithnoResultNewEmployee() throws InterruptedException {
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//*[@id=\"b10-Content\"]/div[4]/a")).click();
			driver.findElement(By.id("Input_SearchVar")).click();
			driver.findElement(By.id("Input_SearchVar")).clear();
			driver.findElement(By.id("Input_SearchVar")).sendKeys("Short");
			WebElement ActResult2 = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));
			int amount = Integer.parseInt(ActResult2.getText());
			int displayResult = 0;

			if (amount == displayResult) {
				System.out.print("Result is:" + amount);
				Assert.assertEquals(amount, displayResult, "Count should be:");

			}

		}
		
		//Searching validation (Resigned Employee)
		//@Test(priority = 11)

		public void SearchingwithResultResignedEmployee () throws InterruptedException {
			
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"b10-Content\"]/div[4]/a")).click();
			driver.findElement(By.cssSelector("#b3-Column2 > div.table-container"));
			driver.findElement(By.id("Input_SearchVar")).click();
			driver.findElement(By.id("Input_SearchVar")).sendKeys("SHOEMART, INC.");
			
			Thread.sleep(2000);
			//Result validation
			WebElement ExpResult = driver.findElement(By.id("Input_SearchVar"));
			String ExpResult1 = ExpResult.getAttribute("value");
			//ExpResult.getText();
			
			
			
			//WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		   //	wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("#b3-Column2>div>table>tbody>tr>td:nth-child(1)")));
			Thread.sleep(2000);
			WebElement ActResult = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)"));
			ActResult.getText();
			
			//WebElement table = driver.findElement(By.cssSelector("#b3-Column2>div>table"));
			//java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
			
			List<String> AllResult = new ArrayList <String>();

			
			//List<String> ActResult = new ArrayList <String>();
			//Thread.sleep(4000);

			List<WebElement> NameElement = driver.findElements(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)"));

			
				for (WebElement Result : NameElement) {
					AllResult.add(Result.getText());
				}
			for (String displayResult : AllResult) {
				
				//driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)")).getText();
				
					
				System.out.println ("Showing resut " + displayResult);
				//Assert.assertEquals(ExpResult, displayResult, "Search Result should be:");
				
				
			if (displayResult == ExpResult1) {
				
				Assert.assertEquals(displayResult, ExpResult1, "Search Result should be:");
			}
			}
			Thread.sleep(2000);
			driver.findElement(By.id("Input_SearchVar")).click();
			driver.findElement(By.id("Input_SearchVar")).clear();
			driver.findElement(By.id("Input_SearchVar")).sendKeys("Short");
			WebElement ActResult2 = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));
			int amount = Integer.parseInt(ActResult2.getText());		
			int displayResult = 0;
			
			if (amount == displayResult) {
				System.out.print("Result is:" + amount);
				Assert.assertEquals(amount, displayResult, "Count should be:");
				
			}
			}

			@Test(priority = 12)

			public void SearchingwithnoResultResignedEmployee() throws InterruptedException {
				Thread.sleep(2000);
				// driver.findElement(By.xpath("//*[@id=\"b10-Content\"]/div[4]/a")).click();
				driver.findElement(By.id("Input_SearchVar")).click();
				driver.findElement(By.id("Input_SearchVar")).clear();
				driver.findElement(By.id("Input_SearchVar")).sendKeys("Short");
				WebElement ActResult2 = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));
				int amount = Integer.parseInt(ActResult2.getText());
				int displayResult = 0;

				if (amount == displayResult) {
					System.out.print("Result is:" + amount);
					Assert.assertEquals(amount, displayResult, "Count should be:");

				}

			}
			//Searching validation (Resigned Employee)
			//@Test(priority = 13)

			public void SearchingwithResultProbEmployee () throws InterruptedException {
				
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"b8-Content\"]/div[4]/a")).click();
				driver.findElement(By.cssSelector("#b3-Column2 > div.table-container"));
				driver.findElement(By.id("Input_SearchVar")).click();
				driver.findElement(By.id("Input_SearchVar")).sendKeys("SHOEMART, INC.");
				
				Thread.sleep(2000);
				//Result validation
				WebElement ExpResult = driver.findElement(By.id("Input_SearchVar"));
				String ExpResult1 = ExpResult.getAttribute("value");
				//ExpResult.getText();
				
				
				
				//WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
			   //	wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("#b3-Column2>div>table>tbody>tr>td:nth-child(1)")));
				Thread.sleep(2000);
				WebElement ActResult = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)"));
				ActResult.getText();
				
				//WebElement table = driver.findElement(By.cssSelector("#b3-Column2>div>table"));
				//java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
				
				List<String> AllResult = new ArrayList <String>();

				
				//List<String> ActResult = new ArrayList <String>();
				//Thread.sleep(4000);

				List<WebElement> NameElement = driver.findElements(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)"));

				
					for (WebElement Result : NameElement) {
						AllResult.add(Result.getText());
					}
				for (String displayResult : AllResult) {
					
					//driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(1)")).getText();
					
						
					System.out.println ("Showing resut " + displayResult);
					//Assert.assertEquals(ExpResult, displayResult, "Search Result should be:");
					
					
				if (displayResult == ExpResult1) {
					
					Assert.assertEquals(displayResult, ExpResult1, "Search Result should be:");
				}
				}
				Thread.sleep(2000);
				driver.findElement(By.id("Input_SearchVar")).click();
				driver.findElement(By.id("Input_SearchVar")).clear();
				driver.findElement(By.id("Input_SearchVar")).sendKeys("Short");
				WebElement ActResult2 = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));
				int amount = Integer.parseInt(ActResult2.getText());		
				int displayResult = 0;
				
				if (amount == displayResult) {
					System.out.print("Result is:" + amount);
					Assert.assertEquals(amount, displayResult, "Count should be:");
					
				}
				}

				@Test(priority = 14)

				public void SearchingwithnoResultProbEmployee() throws InterruptedException {
					Thread.sleep(2000);
					// driver.findElement(By.xpath("//*[@id=\"b10-Content\"]/div[4]/a")).click();
					driver.findElement(By.id("Input_SearchVar")).click();
					driver.findElement(By.id("Input_SearchVar")).clear();
					driver.findElement(By.id("Input_SearchVar")).sendKeys("Short");
					WebElement ActResult2 = driver.findElement(By.cssSelector("#b3-Column2>div>table>tbody>tr>td:nth-child(3)"));
					int amount = Integer.parseInt(ActResult2.getText());
					int displayResult = 0;

					if (amount == displayResult) {
						System.out.print("Result is:" + amount);
						Assert.assertEquals(amount, displayResult, "Count should be:");

					}

				}
}
