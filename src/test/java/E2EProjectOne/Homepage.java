package E2EProjectOne;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.ForgotPasswordObjects;
import PageObjects.Landingpageobjects;
import PageObjects.Loginpageobjects;
import Resources.Baseclass;

public class Homepage extends Baseclass{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Baseclass.class.getName());
	
	@BeforeTest
	public void driverInitialize() throws IOException {
		driver=initializeDriver();
		
	}

	@Test(dataProvider = "getDataProvider")
 public void homePageNavigation(String uName, String uPwd) throws IOException, InterruptedException {
	 driver.get(URL);
	 Landingpageobjects lpo=new Landingpageobjects(driver); 
	 
	 Loginpageobjects loginObj = lpo.getLogin();
	 loginObj.getEmail().sendKeys(uName);
	 loginObj.getPassword().sendKeys(uPwd);
	 loginObj.getButton().click();
	 System.out.println(uName+","+uPwd);
	 log.info("Invalid User Name & Password");
	 log.info("GitDemo Master change");
	 
	 ForgotPasswordObjects fpObj = loginObj.getForgotPwd();
	 fpObj.getEmail().sendKeys("rajeev@gmail.com");
	 //Thread.sleep(1000);
	 fpObj.getMeInstruction().click();
 }
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	
	@DataProvider
	public Object[][] getDataProvider() {
		
		Object[][] data = new Object[2][2];
		
		data[0][0]= "rajeev";
		data[0][1]= "Test@123";
		
		data[1][0]= "vidya";
		data[1][1]= "Test@123";
		
		return data;
		
	}
}
