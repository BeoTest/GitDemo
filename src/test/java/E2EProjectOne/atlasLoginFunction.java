package E2EProjectOne;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.atlasHomePageObjects;
import PageObjects.atlasLoginPageObjects;
import Resources.Baseclass;

public class atlasLoginFunction extends Baseclass{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Baseclass.class.getName());
	
	@BeforeTest
	public void driverInitialize() throws IOException {
		driver=initializeDriver();
		
	}
	
	@Test(dataProvider = "getDataProvider")
	public void atlasUserLogin(String uName, String uPswd) throws IOException {
		//driver=initializeDriver();
		 
		URL = proObj.getProperty("atlasUrl");
		System.out.println(URL);
		driver.get(URL);
		System.out.println(driver.getTitle());
		atlasLoginPageObjects alpObj = new atlasLoginPageObjects(driver);
		alpObj.getUserId().sendKeys(uName);
		alpObj.getPswd().sendKeys(uPswd);
		atlasHomePageObjects ahpObj = alpObj.getLogin();
		log.info("User:"+ uName +"Logged Out");
		ahpObj.getLogOut();
		/*
		 * System.out.println(driver.findElement(By.className("div.left-align")).
		 * isDisplayed());
		 * 
		 * 
		 * if(driver.findElement(By.className("div.left-align")).isDisplayed()){
		 * log.info("User Login Success"); }
		 */
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	
	@DataProvider
	public Object[][] getDataProvider() {
		
		Object[][] data = new Object[2][2];
		
		data[0][0]= "shibin1";
		data[0][1]= "Test@123";
		
		data[1][0]= "toji1";
		data[1][1]= "Test@123";
		
		return data;
		
	}
}
