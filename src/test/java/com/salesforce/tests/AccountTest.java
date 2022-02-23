package com.salesforce.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.salesforce.basetest.BaseTest;
import com.salesforce.pages.account.AccountPage;
import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.sfdclogin.LoginPage;
import com.salesforce.utility.CommonUtilities;


public class AccountTest extends BaseTest {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	AccountPage account;
	CommonUtilities common = new CommonUtilities();

	@BeforeMethod
	public void beforeTest(Method method) throws Exception {
		report.startSingleTestReport(method.getName());
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		account = new AccountPage(driver);
		login.loginapplication();
		report.logTestInfo("UserName, Password is entered and Login is clicked");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		account.enterintoAccount();
		Thread.sleep(3000);
		//account.clickclosepop();

	}
	
	@Test	
	public void SelectAccount() throws Exception {
        home.HomePageTitle();
		account.CreatenewAccount();
	    account.ClickAccount();
		Thread.sleep(1000);
		account.AccountName();
		account.enterintoTypeDropdown();
		Thread.sleep(1000);
		account.enterintoTypeDropdown();
		account.enterintoCustomerPriority();
		Thread.sleep(1000);
		account.ClickAccountSave();
		System.out.println("Clicked on Save button..");
		System.out.println("create account is completed");	
}
  
	@Test	
	public void Selectnewview() throws Exception {
	    account.SelectViewDropdown();
	    account.ClickEdit();
	    account.deleteAccountName();
	    switchtoAlert(driver);
		account.enterintocreateNewView();
		account.enterViewName();
		account.enterUniqueName();
		Thread.sleep(1000);
		account.SaveCreatenewview();
		Thread.sleep(10000);
		account.ClickViewDropdown();
		System.out.println("Createnewview is completed");
		
}
  
   @Test
   public void SelectEditview() throws Exception {
      account.ClickViewDropdown();
	  Thread.sleep(20000);
	  account.ClickEdit();
	  Thread.sleep(6000);
	  account.EnterEditviewname();
	  account.SelectFilterField();
	  account.SelectOperator();
      account.Selectvalue();
      Thread.sleep(3000);
      account.SaveEditview();

}
   
@Test
public void MergeAccount() throws Exception {
	account.ClickMergeaccount();
	account.Enternameoftheaccount();
	account.ClickFindAccount();
	//account.ClickRadiobutton1();
	account.ClickRadiobutton2();
	Thread.sleep(3000);
	account.ClickNext();
	account.ClickMerge();
	switchtoAlert(driver);	
   System.out.println("TC13_MergeAccounts is completed");
	}

@Test
public void CreateAccountreport() throws Exception {
	account.Accountwithlastactivity();
	Thread.sleep(6000);
	account.Datefielddropdown();
	account.ClickCreateDate();
	account.CalendarStartdate();
	account.TodayStartdate();
	account.CalendarEnddate();
	Thread.sleep(10000);
	account.TodayEnddate();;
	Thread.sleep(6000);
	account.SaveCreatedate();
	account.EnterreportName();
	account.EnterReportUniqueName();
	Thread.sleep(3000);
	account.ClicksaveandRun();
	System.out.println("create account report is completed");
	}
}

