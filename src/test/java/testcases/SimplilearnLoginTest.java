package testcases;

//import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class SimplilearnLoginTest extends BaseClass{


	@Test
	public void Test1() { //Negative Login
		
		test.log(LogStatus.INFO, "Test 1 Started");
		
		
		System.out.println("Inside Test 1");
		
		//calling the Login method - the driver will be called from the BaseClass driver
		LoginPage lp = new LoginPage(driver);
		lp.Login("abc@xyz.com","Abc@1234");
		
		/* moved to BaseClass BeforeMthod
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		*/
		
		/*
		//Moved to LoginPage Class
		//Step1. Click on the Login link
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();

		//Step2. Enter Username
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");
		
		//Step3. Enter Password
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Test@1234");
		
		//Step 4. Click Remember Me checkbox
		WebElement Checkbox=driver.findElement(By.className("rememberMe"));
		Checkbox.click();
		
		//Step5. Click on Login  Button
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();
		*/
		
		
		//Step6. Validate the error message on screen
		WebElement Error = driver.findElement(By.id("msg_box"));
		
		String ActError = Error.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		//if(test.log(LogStatus.PASS,test.addScreenCapture(C:\\Users\\mchoi\\eclipse-workspace\\Selenium_Maven));
		//{
		//else {
		//	System.out.println("Test to see screenshot captured");
		//}
		//}
		
		/*
		if(ActError.equals(ExpError)) {
			System.out.println("TC passed");
		}else {
			System.out.println("TC failed");
		}
		*/
		
		//Using Assertions to test if a Test fails (only work inside @Test) - use instead of the If/Else statement above
		Assert.assertTrue(Error.isDisplayed()); //Asserting if the error displays or not (True or False)
		//Assert.assertFalse(Error.isDisplayed());
 		Assert.assertEquals(ActError,  ExpError);
		
		/*
		//Lists all hyperlinks
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total num of links are " + Links.size());
		
		for(int index=0;index<Links.size();index++) {
			
			System.out.println(Links.get(index).getAttribute("href"));
		}
		
		
		/*Move to BaseClass AfterMethod
		//Step7. Close the browser
		driver.close();
		*/
	}
	
	@Test
	@Parameters({"uname","pwd"}) //adding parameter used in xml file - can only run via testng.xml
	public void Test2(String UserName, String Password) { //Positive Login
		
		test.log(LogStatus.INFO, "Test 2 Started");
		
		System.out.println("Inside Test 2");
				
		//calling the Login method - the driver will be called from the BaseClass driver
		LoginPage lp = new LoginPage(driver);
		lp.Login(UserName,Password);
	
	}
	
	@Test
	public void Test3() { //this test allows you to get the data from excel file via BaseClass.java - this test case needs to be run from here (does not run from xml)
		
		test.log(LogStatus.INFO, "Test 3 Started");
		System.out.println("Inside Test 3");
		
		//this grabs the data from the Row/Column the data is
		String UserName = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage lp = new LoginPage(driver);
		lp.Login(UserName,Password);
	}
	
}