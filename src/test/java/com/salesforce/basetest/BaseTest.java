package com.salesforce.basetest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.sfdclogin.LoginPage;
import com.salesforce.pages.usermenu.MyProfilePage;
import com.salesforce.pages.usermenu.UserMenuPage;
import com.salesforce.utility.CommonUtilities;
import com.salesforce.utility.Constants;
import com.salesforce.utility.GenerateReports;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static GenerateReports report = GenerateReports.getInstance();		
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static UserMenuPage usrMenuPg;
	protected static MyProfilePage pro;
	protected static String username=CommonUtilities.getApplicationProperty("email");
	protected static String password=CommonUtilities.getApplicationProperty("password");

	
	@BeforeTest
	public void setUp() {
		System.out.println("Before class executing");
		report.startExtentReport();
		System.out.println("Before class ended");
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void initialSetUp(String browserName,Method method) {
		report.startSingleTestReport(method.getName());
		System.out.println("Starting the browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(CommonUtilities.getApplicationProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		usrMenuPg = new UserMenuPage(driver);
		pro = new MyProfilePage(driver); 
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			report.logTestpassed();
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			report.logTestFailed();
			String path = takescreenshot();
			try {
				report.logger.addScreenCaptureFromPath(path);
				//report.logger.addScreenCaptureFromPath(path, path)
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
		report.logTestInfo("Test ended");
	}
	
	@AfterTest
	public void endUp() {
		report.endTestReport();
	}
	
	public static String takescreenshot() {
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String filePath=Constants.SCREENSHOT_PATH + "salesforce.jpg";
		File DestFile=new File(filePath);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
}
