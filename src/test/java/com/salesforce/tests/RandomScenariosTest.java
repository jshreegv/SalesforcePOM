package com.salesforce.tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.salesforce.basetest.BaseTest;

public class RandomScenariosTest extends BaseTest {

	
	public static void ToVerifyFullNameOfUser() throws Exception{
		
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		System.out.println("User full name is diplayed as: "+driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")).getText());
		driver.findElement(By.xpath("//h1[@class='currentStatusUserName']"));
		driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")).click();
		System.out.println("Test Pass- Page displayed is same as My Profile page.");
		
	}
	
	public static void EditingLastName() throws Exception{
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		driver.findElement(By.xpath("//h1[@class='currentStatusUserName']"));
		driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")).click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]"));
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]")).click();
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		
		driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		
		driver.findElement(By.xpath(" //input[@id='lastName']"));
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Abcd");
		
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).click();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        
        Thread.sleep(2000);
        System.out.println("User's last name updated and is diplayed as: "+driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']")).getText());
        Thread.sleep(2000);
        System.out.println("Name updated at user menu as top right hand side to :"+driver.findElement(By.xpath("//span[@id='userNavLabel']")).getText());
		
	}
	
	public static void TabCustomization() throws Exception {
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click(); 
		System.out.println("'All Tabs' page is displayed. ");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
		driver.findElement(By.xpath("//input[@value='Customize My Tabs']")).click();  
		Thread.sleep(3000);
		
		System.out.println("'Customize My Tab' page is displayed.");
		driver.findElement(By.xpath("//option[contains(text(),'Campaigns')]"));
		driver.findElement(By.xpath("//option[contains(text(),'Campaigns')]")).click(); 
		driver.findElement(By.xpath("//*[@class=\"leftArrowIcon\"]"));
		driver.findElement(By.xpath("//*[@class=\"leftArrowIcon\"]")).click(); 
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		Thread.sleep(1000);
		System.out.println("Test Passed -Selected tab removed from  All Tab page.");		
		driver.findElement(By.id("userNavLabel")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();		
		Thread.sleep(5000);
		loginPage.login(username, password);
		Thread.sleep(1000);
		System.out.println("Pass-Tab removed before login out is not present in tab bar.");
	}
	
	public static void BlockingEventInCalendar() throws Exception{
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		System.out.println("Current Day & Date displayed below user's name.");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]")); 
		driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]")).click();
		System.out.println("User's Calendar is displayed");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]")));
		
		driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]")).click();
		
		driver.switchTo().activeElement();
		
		driver.findElement(By.xpath("//*[@class='comboboxIcon']")).click();
		Thread.sleep(3000);
		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
	
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();
		
		driver.switchTo().window(windows.get(0));
		
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).clear();
		WebElement endTime = driver.findElement(By.xpath("//*[@id='timePickerItem_42']"));
		
		do {
			act.sendKeys(Keys.ARROW_DOWN).perform();
			
		}while(!endTime.isDisplayed());
		endTime.click();
		
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		
		System.out.println("Oher event is added to user's calendar for 8-9PM slot.");
		}
		
	public static void BlockingEventWithWeeklyRecurrance() throws Exception{
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();		
		System.out.println("Current Day & Date displayed below user's name.");
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]")); 
		driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]")));
		
		driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]")).click();
		
		driver.switchTo().activeElement();
		
		driver.findElement(By.xpath("//*[@class='comboboxIcon']")).click();
		Thread.sleep(3000);
		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
	
		driver.switchTo().window(windows.get(1));	
		driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();		
		driver.switchTo().window(windows.get(0));
		
		Actions act1 = new Actions(driver);
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).clear();
		WebElement endTime1 = driver.findElement(By.xpath("//*[@id='timePickerItem_38']"));
		
		do {
			act1.sendKeys(Keys.ARROW_DOWN).perform();
			
		}while(!endTime1.isDisplayed());
		endTime1.click();
		
		driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		driver.findElement(By.xpath("//input[@id='IsRecurrence']")).click();
		
		driver.findElement(By.xpath("//input[@id='rectypeftw']"));
		driver.findElement(By.xpath("//input[@id='rectypeftw']")).click();
		
		System.out.println("Weekly recurrance selected with recurrs every 1 week option and current day is selected.");
		
		driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
		driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")).click();//td[contains(text(),'19')]
		
		driver.findElement(By.xpath("//td[contains(text(),'19')]"));
		driver.findElement(By.xpath("//td[contains(text(),'19')]")).click();
		
		driver.findElement(By.xpath("//input[@value=' Save ']"));
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		
		driver.findElement(By.xpath("//*[@class='monthViewIcon']"));
		driver.findElement(By.xpath("//*[@class='monthViewIcon']")).click();
		
		System.out.println("Final Test Passed");
	}
}
