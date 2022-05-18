package PageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpageobjects {
	
	public WebDriver driver;
	By email = By.id("user_email");
	By pwd = By.id("user_password");
	By submit = By.cssSelector("input[type='submit']");
	By forgotPwd = By.cssSelector("[href*='password/new']");
	
	public Loginpageobjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(pwd);
	}
	
	public WebElement getButton() {
		return driver.findElement(submit);
	}
	
	public ForgotPasswordObjects getForgotPwd() {
		driver.findElement(forgotPwd).click();
		return new ForgotPasswordObjects(driver);
	}

}
