package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class atlasHomePageObjects {
	
	WebDriver driver;


	By logOut = By.cssSelector("span[class*='top-menu-logout']");

	public atlasHomePageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void getLogOut() {
		driver.findElement(logOut).click();
	}

}
