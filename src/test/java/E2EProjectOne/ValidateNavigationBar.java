package E2EProjectOne;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Landingpageobjects;
import Resources.Baseclass;


public class ValidateNavigationBar extends Baseclass{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Baseclass.class.getName());
	
	@BeforeTest
	public void driverInitialize() throws IOException {
		driver=initializeDriver();
		driver.get(URL);
	}
	
	@Test
	 public void ValidateNavigation() throws IOException {
		 
		 Landingpageobjects lpo=new Landingpageobjects(driver);
		// System.out.println(lpo.getTitle().getText());
		 Assert.assertTrue(lpo.getNavigation().isDisplayed());
		 log.info("Validate Navigation Bar Completed");
	 }
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
