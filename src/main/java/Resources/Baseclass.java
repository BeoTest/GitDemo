package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.google.j2objc.annotations.Property;

public class Baseclass {
	
	WebDriver driver;
	public String URL;
	public static ExtentReports extent;
	public Properties proObj;
	
	public WebDriver initializeDriver () throws IOException {
		
		proObj= new Properties();
		String dataPath = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Data.properties";
		System.out.println(dataPath);
		FileInputStream fis = new FileInputStream(dataPath);
		proObj.load(fis);
		String browserName = proObj.getProperty("browser");
		System.out.println(browserName);
		URL = proObj.getProperty("url");
		System.out.println(URL);
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Rajeev\\Personal Files\\Interview Doc\\study\\Selenium_Meterials\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Rajeev\\Personal Files\\Interview Doc\\study\\Selenium_Meterials\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshotCaptured(String methodName, WebDriver driver) throws IOException {
		
		File var = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenCaptured=System.getProperty("user.dir")+"//reports//"+methodName+".png";
		FileUtils.copyFile(var, new File(screenCaptured));
		return screenCaptured;
	}
	
	public static ExtentReports getReporterObject() {
		
		String reportPath = System.getProperty("user.dir")+"//reports//index.html";
		extent = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Selenium Web Automation");
		reporter.config().setDocumentTitle("Automation Test Title");
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Engineer", "Rajeev Kumar");
		
		return extent;
	}

}

