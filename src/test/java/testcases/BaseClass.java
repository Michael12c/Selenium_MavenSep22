package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus; 

public class BaseClass {

	WebDriver driver;
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	ExtentReports report;
	ExtentTest test;
	//ExtentHtmlReporter htmlReporter;
	
	@BeforeTest
	public void DataSetUp() throws IOException { //you can throw the exception or add a Try/Catch block
		
		System.out.println("Inside Before Test");
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		
		this.wbook = new XSSFWorkbook(fis);
		this.sheet = wbook.getSheet("Sheet1");
		
		report = new ExtentReports("AutomationTest_Report.html");
		
		
	}
	
	@AfterTest
	public void DataClean() throws IOException {
		
		System.out.println("Inside After Test");
		//Clean all objects that was created - close excel
		
		wbook.close();
		report.flush(); //removes everything from memory
		report.close(); 
		
		
	}
	
	@BeforeMethod
	public void SetUp(Method method) {
		
		test = report.startTest(method.getName());
		
		System.out.println("Inside Before Method");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		
	}

	@AfterMethod
	public void TearDown() {
		
		System.out.println("Inside After Method");
		
		report.flush();
		report.endTest(test);
		
		//Step7. Close the browser
		driver.close();
	}
}
