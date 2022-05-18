package PageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpageobjects {
	
	public WebDriver driver;
	By login = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector("div[class='text-center'] h2");
	By navigation = By.xpath("//a[text()='Contact']");
	
	public Landingpageobjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public Loginpageobjects getLogin() {
		driver.findElement(login).click();
		Loginpageobjects loginObj=new Loginpageobjects(driver);
		return loginObj;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigation() {
		return driver.findElement(navigation);
	}

}
