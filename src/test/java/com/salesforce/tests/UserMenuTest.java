package com.salesforce.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.salesforce.basetest.BaseTest;
import com.salesforce.pages.usermenu.MyProfilePage;
import com.salesforce.pages.usermenu.MySettingsPage;
import com.salesforce.pages.usermenu.UserMenuPage;
import com.salesforce.utility.Constants;

public class UserMenuTest extends BaseTest {
	static ITestResult result;
	static UserMenuPage usrMenuPg; 

	@Test
	public void SelectUserMenu_5() {
		try {
			usrMenuPg.clickUserMenu();
			report.logTestInfo("usermenu clicked");			
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	@Test
	public static void MyProfile_6() {
		try {
			loginPage.login(username, password);
			String lastName = "ABCD";
			homePage.clickUserMenu();
			pro.Myprofile();
			report.logTestInfo("my profile clicked");
			//Assert.assertTrue(pro.waitUntilTitleContains("User"));
			pro.EditProfile();
			report.logTestInfo("switched to editprofile");
			pro.AboutTab();
			pro.lName("lastName");
			report.logTestInfo("last name entered");
			//Assert.assertEquals(pro.getLname(), lastName);	
			pro.SaveAll();
			pro.Post();
			pro.PostTxt("hello");
			report.logTestInfo("text entered to post");
			pro.ShareButton();
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	public static void MySettings_7() {
		try {
			loginPage.login(username, password);
			homePage.clickUserMenu();
			MySettingsPage settings = new MySettingsPage(driver);
			settings.MySettings();
			report.logTestInfo("my settings clicked");
			settings.moveToPersonal();
			report.logTestInfo("moved to personal");
			settings.historyLogin();
			settings.downloadHistory();
			report.logTestInfo("Data downloaded in .csv format");
			settings.displayAndLayout();
			settings.customizeTab();
			settings.customApp("Salesforce Chatter");
			report.logTestInfo("customapp selected");
			settings.availTabs("Service Contracts");
			settings.AddButton();
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
	}
}
