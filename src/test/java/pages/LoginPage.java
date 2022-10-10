package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//*************	Objects********************
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(className = "rememberMe")
	WebElement Checkbox;
	
	@FindBy(name = "btn_login")
	WebElement LoginBtn;
	
	//Using Constructor to resolve driver null pointer exception - to assign value of driver
	public LoginPage(WebDriver basedriver) {
		
		this.driver = basedriver;
		PageFactory.initElements(basedriver, this); //this allows your @FindBy elements to know which driver to intialise the elements
	}
	
	
	//*************Methods********************
	
	//Parameterisation - passing values instead of hardcoding values
	public void Login(String UserNameVal, String PassVal) {
		
		
		//Step1. Click on the login link
		
		//LoginLink = driver.findElement(By.linkText("Log in")); //removed declaration from method as using @FindBy
		LoginLink.click();

		//Step2. Enter Username
		//UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys(UserNameVal);
		
		//Step3. Enter Password
		//Password = driver.findElement(By.id("password"));
		Password.sendKeys(PassVal);
		
		//Step 4. Click Remember Me checkbox
		//Checkbox=driver.findElement(By.className("rememberMe"));
		Checkbox.click();
		
		//Step5. Click on Login  Button
		//LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();
		
		
	}

	public void UIValidation() {
		
		
	}
}
