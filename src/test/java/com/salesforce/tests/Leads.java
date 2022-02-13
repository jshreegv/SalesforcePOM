package com.salesforce.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.basetest.BaseTest;

public class Leads extends BaseTest {

	@Test
	public static void LeadsViewDropDown() throws Exception {
		
		Select se = new Select(driver.findElement(By.id("fcf")));
		System.out.println("Following options available: ");
		List<WebElement> e = se.getOptions();
		int listSize = e.size();
		
		for (int i =0; i <listSize; i++) {
			
			System.out.println(e.get(i).getText());
			
		}
	}
	
	@Test
	public static void FunctionalityOfGoButton() throws Exception {
		
		Select se1 = new Select(driver.findElement(By.id("fcf")));
		se1.selectByVisibleText("My Unread Leads");
		homePage.logout();
		Thread.sleep(3000);
		loginPage.login(username, password);
		driver.findElement(By.xpath("//a[@title='Leads Tab']")).click();
		driver.findElement(By.xpath("//input[@value=' Go! ']"));
		driver.findElement(By.xpath("//input[@value=' Go! ']")).click();
	}
	
	@Test
	public static void TodaysLeadsLink() throws Exception {
		
		Select se1 = new Select(driver.findElement(By.id("fcf")));
		se1.selectByVisibleText("Today's Leads");
		driver.findElement(By.xpath("//input[@value=' Go! ']"));
		driver.findElement(By.xpath("//input[@value=' Go! ']")).click();
	}
	
	@Test
	public static void LeadsNewButton() throws Exception{
		
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
		driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		driver.findElement(By.xpath("//input[@id='name_lastlea2']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@id='lea3']"));
		driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@value=' Save ']"));
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();

	}
}
