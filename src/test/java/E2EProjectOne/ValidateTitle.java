package E2EProjectOne;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.Landingpageobjects;
import Resources.Baseclass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ValidateTitle extends Baseclass{
	
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(Baseclass.class.getName());
	
	@BeforeTest
	public void driverInitialize() throws IOException {
		driver=initializeDriver();
		log.info("Driver initialized");
		driver.get(URL);
		log.info("Hit on page"+ URL);
	}
	@Test
	 public void validateTitleMethod() throws IOException {
		 
		 Landingpageobjects lpo=new Landingpageobjects(driver);
		 System.out.println(lpo.getTitle().getText());
		 Assert.assertEquals(lpo.getTitle().getText(), "FEATURED COURSES1");
		log.info("Validate Title Execution completed");
	 }
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
