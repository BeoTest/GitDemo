package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class atlasLoginPageObjects {
	
	WebDriver driver;

	By u_id = By.id("userid");
	By pswd = By.id("password");
	By login = By.id("login");
	By forgotPswd = By.cssSelector(".passwort-vergessen");

	public atlasLoginPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getUserId() {
		return driver.findElement(u_id);
	}

	public WebElement getPswd() {
		return driver.findElement(pswd);
	}

	public atlasHomePageObjects getLogin() {
		driver.findElement(login).click();
		return new atlasHomePageObjects(driver);
	}

	public WebElement getForgotPswd() {
		return driver.findElement(forgotPswd);
	}

}
