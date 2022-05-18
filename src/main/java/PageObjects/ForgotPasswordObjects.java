package PageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordObjects {
	
	public WebDriver driver;
	By email = By.cssSelector("#user_email");
	By sendMeInstruction = By.name("commit");
	
	public ForgotPasswordObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getMeInstruction() {
		return driver.findElement(sendMeInstruction);
	}

}
