package com.salesforce.basetest;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import com.training.log.*;
import org.apache.commons.io.FileUtils;
//import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.salesforce.utility.GenerateReports;
import com.salesforce.utility.Constants;


public class BaseTest {
	private WebDriver driver;
	protected static GenerateReports report=GenerateReports.getInstance();
	
	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
		}
		public WebDriver getDriver1() {
		WebDriverManager.firefoxdriver().setup();
		 WebDriver driver=new FirefoxDriver();
		 return driver;
	}
		
		@BeforeTest
		public void setUp() {
			System.out.println("Before classs is executing");
			report.startExtentReport();
			System.out.println("extent report document is created");
		}
					
		public static void getTitle(String actualtitle, String expectedTitle) {
		  if (actualtitle.equals(expectedTitle)) {
				System.out.println("Pass : User is on that page");
				report.logTestpassed("User is on that page");
				}
			else {
				System.out.println("Fail :  page is not Lunched");
				report.logTestFailed("page is not Lunched");
			}
		  
		}
		
		public void waitforElement(WebElement element){

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			report.logTestInfo("Waiting for the element to be vissible");
		}
		
		
		public void waitUntilAlertIsPresent() {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.alertIsPresent());
			report.logTestInfo("Waiting for the element to be present");
		}
		
		
		public static void enterText(WebElement obj,String textval,String objName) throws Exception

		{
			if(obj.isDisplayed())
			{
				Thread.sleep(4000);
				obj.sendKeys(textval);
				System.out.println("pass: "+textval+"value is entered in "+objName+"field");
				report.logTestpassed("value is entered");
							
			}
			else
			{
				System.out.println("fail:" +objName+ "field does not exist please check application");
				report.logTestFailed("field does not exist please check application");
				
			}
		}
		
		public static void clickObj(WebElement obj,String objName)
		{
			if(obj.isDisplayed())
			{
				obj.click();
				System.out.println("pass :" +objName + "button is clicked");
				report.logTestpassed("button is clicked");
			}
			else
			{
				System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
				report.logTestFailed("button is not displayed ,please check the application");
			}
		}
				
		public static void clearElement(WebElement element) {
			if(element.isDisplayed()) {
				element.clear();
				System.out.println("pass: element cleared");
				report.logTestpassed("element cleared");
			}
			else {
				System.out.println("fail: element not displayed");
				report.logTestFailed("element not displayed");
			}
		}
		public static void selectCheckBox(WebElement obj, String objName) {
			
			if(obj.isDisplayed()) {
				
				if(obj.isSelected()) {
					System.out.println("Pass: "+objName+" is already selected");
					report.logTestInfo(objName);
				}
				else{
				obj.click();
				System.out.println("Pass: "+objName+" is selected");
				report.logTestpassed("checkbox is selected");
			    }
			}
				else {
				System.out.println("Fail:"+objName+" is not present.Please chk application");	
				report.logTestFailed("checkbox element is not displayed ,please check the application");
			}	
		}
		
		public static void selectDropdown(WebElement obj, String objName) {
							
					if(obj.isDisplayed()) {
						obj.click();
						System.out.println("Pass: "+objName+" is  selected");
						report.logTestpassed("dropdown is selected");
					}
					else {
					
						System.out.println("Fail:"+objName+" is not present.Please chk application");	
					     report.logTestFailed("dropdown option is not present.Please chk application");
				    }
				}
					
		public static void dropDownGetOptions(WebElement element, String name) {
			Select select4 = new Select(element);
		List<WebElement> listofOptions = select4.getOptions();
		int size=listofOptions.size();
	    System.out.println("Number of elements: " +size);
	    for (WebElement webElement : listofOptions) {
	    	if(webElement.getText().equals(name)) {
	    		System.out.println("Pass: Account name is displayed in the dropdown");
	    		report.logTestpassed("Account name is displayed in the dropdown");
		}
	    	else {
	    		System.out.println("Fail: Account name is not displayed in the dropdown");
	    		report.logTestFailed("Account name is not displayed in the dropdown");
	    	}
	    }
	}
		
		public static void dropDownList(WebElement element) {
			Select select4 = new Select(element);
		    List<WebElement> listofOptions = select4.getOptions();
		    int size=listofOptions.size();
		    System.out.println("Number of elements: " +size);
		    System.out.println(element.getText());
	        
		}
	
		public static void dropDownoptionsclick(WebElement element, String name) {
			Select select4 = new Select(element);
		List<WebElement> listofOptions = select4.getOptions();
		int size=listofOptions.size();
		 System.out.println("Number of elements: " +size);
		for (WebElement webElement : listofOptions) {
			if(webElement.getText().equals(name))
            {
				webElement.click();
                break;
            }
			System.out.println("Pass: Account name is displayed in the dropdown");
			report.logTestpassed("Account name is displayed in the dropdown");
				}
		}
				
		public static void validateErrormessage(String actualmsg, String errormsg) {

			if(actualmsg.equalsIgnoreCase(errormsg))
			{
				System.out.println("TestCase is passed");
				report.logTestpassed("validation is equal");
			}else
		    {
			System.out.println("TestCase is failed");
			report.logTestFailed("Validation is incorrect");
		    }
		}

	public static void switchFrame( WebDriver driver,WebElement obj) {
		 
	    if(obj.isDisplayed()) {
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	     report.logTestpassed("we can switch to the frame");
	     
	    }else {
	     System.out.println("fail: we can't switch to the "+obj+ " frame");
	     report.logTestFailed("Cannot Switch to frame");
	    }
	}

	public static void switchFrameid( WebDriver driver,String obj) {
		 
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	     report.logTestpassed("we can switch to the frame");
	     
	    }

	public static void switchdefaultFrame( WebDriver driver)
	{
	driver.switchTo().defaultContent();
	System.out.println("Pass: we can switch to the "+ driver + " back to frame");
	report.logTestpassed("we can switch back to the frame");
	}

	
	public static void mouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
	   Actions action=new Actions(driver);
	   action.moveToElement(obj).build().perform();
		System.out.println("Pass: "+obj+" is present");
		report.logTestpassed("obj is present");
		}
	 else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
			report.logTestFailed("obj is not present.Please chk application");
		}
	}
	
	public static void mouseHoverDoubleClick(WebDriver driver, WebElement obj) {
		if(obj.isDisplayed()) {
			   Actions action=new Actions(driver);
			   action.doubleClick(obj).build().perform();
				System.out.println("Pass: "+obj+" is present");
				report.logTestpassed("obj is present");
				}
			 else {
					System.out.println("Fail:"+obj+" is not present.Please chk application");
					report.logTestFailed("obj is not present.Please chk application");
				}

		
	}
	
	public static void mouseHoverContextClick(WebDriver driver, WebElement obj) {
		if(obj.isDisplayed()) {
			   Actions action=new Actions(driver);
			   action.contextClick(obj).build().perform();
				System.out.println("Pass: "+obj+" is present");
				report.logTestpassed("obj is present");
				}
			 else {
					System.out.println("Fail:"+obj+" is not present.Please chk application");
					report.logTestFailed("obj is not present.Please chk application");
				}
	}
 
	public static void SelectbyText(WebElement obj, String VisibleText){
		   if(obj.isDisplayed())
		   {
			   Select selObj=new Select(obj);
	           selObj.selectByVisibleText(VisibleText);
		           System.out.println("Pass: "+VisibleText+ " is Selected by VisibleText" );
		           report.logTestpassed("Selected by VisibleText");
		           
		   } 
		   else
		   {
		    System.out.println("Fail: "+VisibleText+ " is not available");
		    report.logTestFailed("not Selected by VisibleText");
		    
		   }		   
		   
	}

	public static void SelectByValue(WebElement obj, String val) {
		if(obj.isDisplayed()) {
		   Select selObj=new Select(obj);		    
		   selObj.selectByValue(val);
		  System.out.println("pass:"+val + " is selected from drop down ");
		  report.logTestpassed("Element is selected from drop down");		 
		  }
		else {
		   System.out.println("Fail:"+val+"is not selected");
		   report.logTestFailed("Element is not selected from drop down");
		  }
		 }	  

	public static void selectByIndex(WebElement obj, int index) {
		  if(obj.isDisplayed()) {
		   Select selObj=new Select(obj);
		  selObj.selectByIndex(index);
		  
		  System.out.println("pass:"+index + " is selected from drop down ");
		  report.logTestpassed("is selected from drop down");
		  }else {
		   System.out.println("Fail:"+index+"is not selected");
		   report.logTestFailed("Element is not selected from drop down");
		  }
		 }
      
	public static void selectByVisibleText(WebElement obj, String Name) {
		if(obj.isDisplayed()) {
			 Select drop = new Select(obj);
			 drop.selectByVisibleText(Name);
		 System.out.println("Pass: dropdown is selected");
		 report.logTestpassed("is selected from drop down");
		 }
		else {
		 System.out.println("Fail: dropdown is not available check your application");
		 report.logTestFailed("dropdown is not available check your application");
		 }
		 }

	public static void Radiobutton(WebElement obj, String objName) {
		
		if(obj.isDisplayed() ){
			obj.click();
			System.out.println("Pass: "+objName+" is clicked");
			report.logTestpassed("Element is clicked");
		}
		else {
			System.out.println("Fail:"+objName+" is not displayed .Please check your application");	
			report.logTestFailed("Element is not displayed .Please check your application");
		}
	}

	public static void switchtoAlert(WebDriver driver) {
		 driver.switchTo().alert().accept();
		 System.out.println("Pass: alert is present and accept");
		 report.logTestpassed("alert is present and accept");
	}

		public static String takeScreenShot(WebDriver webdriver ) throws Exception{
	        //Convert web driver object to TakeScreenshot
	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	        //Call getScreenshotAs method to create image file
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            String filePath = Constants.SCREENSHOT_PATH+ "salesforce.jpg";
	            //Move image file to new destination
	                File DestFile=new File(filePath);
	                //Copy file at destination
	                FileUtils.copyFile(SrcFile, DestFile);	                
	                return filePath;
	    }
		
		public static void setClipboardData(String string) {
			//StringSelection is a class that can be used for copy and paste operations.
			   StringSelection stringSelection = new StringSelection(string);
			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			}
		
		@AfterMethod
		public void teardown(ITestResult result) throws Exception {
			if (result.getStatus()== ITestResult.SUCCESS) {
			     report.logTestpassed("pass");}
			     else if(result.getStatus()==ITestResult.FAILURE) {
			    	report.logTestFailed("Fail"); 
			    	String path= takeScreenShot(driver);
			    	report.logger.addScreenCaptureFromPath(path);
			     }
				
			driver.close();
		}
		
		@AfterClass
		public void endUp() {
			report.endTestReport();
		}
	}
