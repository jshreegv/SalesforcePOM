package com.salesforce.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.salesforce.basetest.BaseTest;
import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.sfdclogin.LoginPage;
import com.salesforce.utility.CommonUtilities;

public class LoginTest extends BaseTest {

	WebDriver driver;
	LoginPage login;
	HomePage home;
	CommonUtilities common = new CommonUtilities();

	@BeforeMethod
	public void beforeTest() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		}

	@Test
	public void LoginErrorMessage1() throws Exception {
		report.startSingleTestReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		login.EnterintoUserName();
		report.logTestInfo("UserName is entered");
		login.clickLoginButton();
		login.loginErrorMessage();
		System.out.println("Login error message is completed");
		report.logTestInfo("Testcase 1 Login error message is completed");
     }

	@Test
	public void LoginToSalesForce2() throws Exception {
		report.startSingleTestReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		login.loginapplication();
		report.logTestInfo("UserName, Password is entered and Login is clicked");
		System.out.println("Login to Salesforce is completed");
		report.logTestInfo("Testcase 2 Login to Salesforce is completed");
		
		}

	@Test
	public void Check_RemeberMe_3() throws Exception {
		report.startSingleTestReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		login.EnterintoUserName();
		report.logTestInfo("Username is entered");
		login.EnterIntoPassWord();
		report.logTestInfo("Password is entered");
		login.checkRememberme();
		report.logTestInfo("RememberMe is selected");
		login.clickLoginButton();
		report.logTestInfo("Login is clicked");
		home.HomePageTitle();
		home.enterintoUsermenu();
		report.logTestInfo("UserMenu is clicked");
		home.enterintologout();
		report.logTestInfo("Logout is clicked");
		login.CheckUserField();
		System.out.println("Check Remember Me is completed");
		report.logTestInfo("Testcase 3 Check Remember Me is completed");
}
	   	
	@Test
	public void Forgot_Password_4A() throws Exception {
		report.startSingleTestReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		login.EnterintoUserName();
		report.logTestInfo("Username is entered");
		login.forgotPassword();
		login.UserNameField();
		login.Continue();
		login.ForgetPasswordMessage();
		System.out.println("Forget password is completed");
		report.logTestInfo("Testcase 4A Forget password is completed");
	}
	
	@Test
	public void Forgot_Password_4B() throws Exception {
		report.startSingleTestReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		login.EnterintoUserName();
		report.logTestInfo("Username is entered");
		login.EnterIntoWrongPassword();
		report.logTestInfo("WrongPassword is entered");
		login.clickLoginButton();
		report.logTestInfo("Login is clicked");
		login.WrongPasswordAlertMessage();
			System.out.println("testcase is pass");
			System.out.println("Wrong password is completed");
			report.logTestInfo("Testcase 4B Wrong password is completed");
		}
	}
