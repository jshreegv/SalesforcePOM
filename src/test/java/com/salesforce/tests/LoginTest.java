package com.salesforce.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.salesforce.basetest.BaseTest;
import com.salesforce.pages.sfdclogin.ForgotPasswordPage;
import com.salesforce.utility.CommonUtilities;
import com.salesforce.utility.Constants;

public class LoginTest extends BaseTest {
	static ITestResult result;
	//String username=CommonUtilities.getApplicationProperty("email");
	//String password=CommonUtilities.getApplicationProperty("password");
	@Test
	public void LoginErrorMsg_1() {
		try {	
			//String username=CommonUtilities.getApplicationProperty("email");
			loginPage.EnterUserName(username);
			report.logTestInfo("Entered username");
			loginPage.ClickLogin();
			report.logTestInfo("loginbutton clicked");
			//Assert.assertEquals(loginPage.errorText(),Constants.PASSWORD_ERROR1);
		} catch (Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
		System.out.println("test ended");
	}
	
	@Test
	public void LoginToSalesforce_2() {
		try {
			loginPage.EnterUserName(username);
			report.logTestInfo("Entered username");
			loginPage.EnterPassword(password);
			report.logTestInfo("Entered password");
			loginPage.ClickLogin();
			report.logTestInfo("loginbutton clicked");
			//Assert.assertEquals(homePage.getTitleOfpage(), );
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
		
	}

	@Test
	public void CheckRememberMe_3() {
		try {
			loginPage.checkRememberMe();
			report.logTestInfo("remember me checked");
			loginPage.EnterUserName(username);
			report.logTestInfo("Entered username");
			loginPage.EnterPassword(password);
			report.logTestInfo("Entered password");
			loginPage.ClickLogin();
			report.logTestInfo("login successful");
			homePage.clickUserMenu();
			homePage.logout();
			report.logTestInfo("logout successfull");
			Assert.assertEquals(loginPage.getUsername(), username);
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	@Test
	public void ForgotPassword_4a() {
		try {
			ForgotPasswordPage fpage = new ForgotPasswordPage(driver); 
			loginPage.clickForgotPass();
			report.logTestInfo("forgot password clicked");
			//Assert.assertTrue(fpage.titleChk("Forgot Your Password"));
			fpage.enterUser(username);
			report.logTestInfo("username entered");
			fpage.clickContinue();
			report.logTestInfo("continue button clicked");
			//Assert.assertTrue(fpage.titleChk("Check Your Email"));
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
		
	}
	
	@Test
	public void ForgotPassword_4b() {	
		try {
			loginPage.EnterUserName("123");
			loginPage.EnterPassword("22131");
			loginPage.ClickLogin();
			report.logTestInfo("login button clicked");
			//Assert.assertEquals(loginPage.errorText(), Constants.PASSWORD_ERROR2);
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	
	public void login() {
		
			String username1=CommonUtilities.getApplicationProperty("email");
			loginPage.EnterUserName(username1);
			report.logTestInfo("Entered username");
			String password1=CommonUtilities.getApplicationProperty("password");
			loginPage.EnterPassword(password1);
			report.logTestInfo("Entered password");
			loginPage.ClickLogin();
			report.logTestInfo("login successful");
			String title = homePage.getTitleOfpage();
			String title1 = "Home Page";
			Assert.assertEquals(title, title1);
			System.out.println("test ended");
		
	}	
			
}
