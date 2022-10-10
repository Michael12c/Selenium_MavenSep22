package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	//Using Constructor to resolve driver null pointer exception - to assign value of driver
	public HomePage(WebDriver basedriver) {

		this.driver = basedriver;

	}
}