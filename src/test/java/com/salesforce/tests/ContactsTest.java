package com.salesforce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforce.basetest.BaseTest;

public class ContactsTest extends BaseTest{

		@Test
		public static void CreateNewAccount() throws Exception {
			driver.findElement(By.xpath("//input[@value=' New ']"));
			driver.findElement(By.xpath("//input[@value=' New ']")).click();
			driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
			driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("Nair");
			driver.findElement(By.xpath("//input[@id='con4']"));
			driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("Automation");
			driver.findElement(By.xpath("//input[@value=' Save ']"));
			driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		}
		
		@Test
		public static void CreateNewView() throws Exception{
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			driver.findElement(By.xpath("//input[@id='fname']"));
			driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("ContactB");
			driver.findElement(By.xpath("//input[@id='devname']"));
			driver.findElement(By.xpath("//input[@id='devname']")).click();			
			driver.findElement(By.xpath("//input[@value=\" Save \"]")).click();
		}
		
		@Test
		public static void RecentlyCreatedContact() throws Exception{
			Select c = new Select(driver.findElement(By.id("hotlist_mode")));
			c.selectByVisibleText("Recently Created");
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")).getText()+" is displayed!");
			
		}
		
		@Test
		public static void MyContactsView() throws Exception {
			Select c1 = new Select(driver.findElement(By.id("fcf")));
			c1.selectByVisibleText("My Contacts");
			driver.findElement(By.xpath("//input[@value=' Go! ']"));
			driver.findElement(By.xpath("//input[@value=' Go! ']")).click();
		}
		
		@Test
		public static void ViewContact() throws Exception{
			driver.findElement(By.xpath("//a[contains(text(),'Mohan')]"));
			driver.findElement(By.partialLinkText("Mohan")).click();
		}
		
		@Test
		public static void ErrorMessageCreatingNewView() throws Exception{
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			driver.findElement(By.xpath("//input[@id='devname']"));
			driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
			driver.findElement(By.xpath("//input[@value=\" Save \"]")).click();
			System.out.println(driver.findElement(By.xpath("//div[@class='errorMsg']")).getText());
			
		}
		
		@Test
		public static void CancelButtonInCreateNewView() throws Exception{
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			driver.findElement(By.xpath("//input[@id='fname']"));
			driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("ABCD");
			driver.findElement(By.xpath("//input[@id='devname']"));
			driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
			driver.findElement(By.xpath("//input[@value='Cancel']")).click();
		}
		
		@Test
		public static void testingSaveAndNewButtonNewContact() throws Exception{
			driver.findElement(By.xpath("//input[@value=' New ']"));
			driver.findElement(By.xpath("//input[@value=' New ']")).click();
			driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
			driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("Indian");
			driver.findElement(By.xpath("//input[@id='con4']"));
			driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("Global Media");
			driver.findElement(By.xpath("//input[@value='Save & New']"));
			driver.findElement(By.xpath("//input[@value='Save & New']")).click();
			System.out.print("Fail: "+ driver.findElement(By.xpath("//div[@class='errorMsg']")).getText());
			System.out.println(driver.findElement(By.xpath("//div[@id='errorDiv_ep']")).getText());
		}
}
