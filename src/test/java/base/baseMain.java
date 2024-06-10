package base;


import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class baseMain {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr2;
	public static FileReader fr3;
	public static FileReader fr4;
	
   //validation message1
	public static String expectedMessage1 = "The Data you entered contains a letter or special character";
	public static String expectedMessage3 = "Employee already exists in Workforce.";
	public static String expectedMessage4 = "Hire date/System Date is less than or equal to final process date";
	public static String expectedMessage0 = "SSS Nos. Length should be 10 digits.";
	public static String inputSSS = "test";
	//validation message2
	public static String inputSSSM0 = "123";
	public static String inputSSSM3 = "3369877722";
	public static String inputSSSM5 = "3402214608";
	


	
   


	@BeforeTest

	public void setUp() throws IOException, InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		if(driver==null) {
			 fr = new FileReader("C:\\Users\\jvk5400\\eclipse-workspace\\New Work\\HR_WorkForce\\src\\test\\resources\\ConfigFiles\\config.properties");
			 fr2 = new FileReader("C:\\Users\\jvk5400\\eclipse-workspace\\New Work\\HR_WorkForce\\src\\test\\resources\\ConfigFiles\\locators.properties");
			 fr3 = new FileReader("C:\\Users\\jvk5400\\eclipse-workspace\\New Work\\HR_WorkForce\\src\\test\\resources\\ConfigFiles\\AddFamilyMember.properties");
			 fr4 = new FileReader("C:\\Users\\jvk5400\\eclipse-workspace\\New Work\\HR_WorkForce\\src\\test\\resources\\ConfigFiles\\Employment.properties");

			prop.load(fr);
			loc.load(fr2);
			loc.load(fr3);
			loc.load(fr4);
		
		}
		
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_webdriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			
			
			
			driver.get(prop.getProperty("url"));
			
			Thread.sleep(20000);
			
			driver.findElement(By.id("Input_UsernameVal")).sendKeys("3445030182");
			driver.findElement(By.id("Input_PasswordVal")).sendKeys("P@ssw0rd1993");
			
			driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/form/div[2]/div/div/button")).click();
			Thread.sleep(10000);
			//Dimension dm = new Dimension(1450,563);
			//driver.manage().window().setSize(dm);

			driver.findElement(By.xpath("//span[contains(text(),'Workforce')]")).click();
			
		}
			

	
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			Thread.sleep(10000);
	
		}
			
	}
	//private static void zoomout (WebDriver driver) {
		
		//((JavascriptExecutor)driver).executeScript("document.-body.style.zoom='0.8';");
	//}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		System.out.println("Teardown Successfull");
		
	}
	
}
