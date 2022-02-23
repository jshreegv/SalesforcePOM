package com.salesforce.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.salesforce.basetest.BaseTest;
import com.salesforce.pages.account.AccountPage;
import com.salesforce.pages.contacts.ContactsPage;
import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.leads.LeadsPage;
import com.salesforce.pages.opportunity.OpportunityPage;
import com.salesforce.pages.sfdclogin.LoginPage;
import com.salesforce.utility.CommonUtilities;


public class ContactsTest extends BaseTest {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	AccountPage account;
	OpportunityPage opportunity;
	LeadsPage leads;
	ContactsPage contacts;
	static Actions action;
	static  WebDriverWait wait;
	CommonUtilities common = new CommonUtilities();
	
	
	@BeforeMethod
	public void beforeMethod(Method method) throws Exception {
		report.startSingleTestReport(method.getName());
		driver = getDriver();
	    String url = common.getApplicationProperty("url");
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		account = new AccountPage(driver);
		opportunity = new OpportunityPage(driver);
		leads = new LeadsPage(driver);
		contacts = new ContactsPage(driver);
		login.loginapplication();
		report.logTestInfo("UserName, Password is entered and Login is clicked");
		contacts.EnterContacts();
			Thread.sleep(10000);
		//account.clickclosepop();
	}
	
   @Test
   public void CreateNewcontact() throws Exception {
		
		contacts.NewContacts();
		contacts.EnterContactslastname();
		opportunity.ClickLookup();
		Thread.sleep(10000);
		String oldWindow = driver.getWindowHandle();
		contacts.WindowHandle(oldWindow);
		Thread.sleep(3000);
		driver.switchTo().frame("searchFrame");
		opportunity.EnterNameinLookup();
		opportunity.ClickGo();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("resultsFrame");
		Thread.sleep(5000);
		opportunity.PickaccountName();
		driver.switchTo().window(oldWindow);
		contacts.SaveNewContacts();
		System.out.println("Createnewcontact is completed");
		
}
   
   	@Test	
	public void newviewinContactPage() throws Exception {
        contacts.CreateNewviewLink();
		contacts.EnterViewname();
		contacts.EnterViewUniquename();
		contacts.SaveContacts();
		System.out.println("CreatenewviewintheContactPage is Completed");
		
}
   	
   @Test
   public void Checkrecentlycreatedcontact() throws Exception {
       contacts.Recentlycreateddropdown();
	   System.out.println("Checkrecentlycreatedcontact is Completed");

}	

   @Test
   public void CheckMycontacts() throws Exception {
       leads.ListhandleDropdown();
	   leads.SelectListhandleDropdown();
	   Thread.sleep(3000);
	   System.out.println("MyContacts is Completed");

}
   
   @Test
   public void Viewcontacts() throws Exception {
       contacts.RecentContactName();
       System.out.println("ViewcontactinthecontactPage is completed");
}
   
   @Test
   public void ErrorMessage() throws Exception {
       contacts.CreateNewviewLink();
	   contacts.EnterViewUniquename2();
	   Thread.sleep(1000);
	   contacts.SaveContacts();
	   Thread.sleep(3000);
	   contacts.ErrorMessageText();
	   System.out.println("ChecktheContactErrormessage is Completed");
}
   
   @Test
   public void CheckCancelButton() throws Exception {
       contacts.CreateNewviewLink();
	   contacts.EnterViewname2();
	   contacts.EnterViewUniquename2();
	   contacts.ClickcancelButton();
	   System.out.println("CheckingCancelbutton is Completed");
   }

   @Test
   public void CheckingSaveandNewbutton() throws Exception {
       leads.ClickNew();
       contacts.EnterContactslastname();
	   opportunity.ClickLookup();
	   Thread.sleep(10000);
	   String oldWindow = driver.getWindowHandle();
	   contacts.WindowHandle(oldWindow);
	   Thread.sleep(3000);
       //switch to first frame
	   driver.switchTo().frame("searchFrame");
	   opportunity.EnterNameinLookup();
	   opportunity.ClickGo();
	   driver.switchTo().defaultContent();
	   driver.switchTo().frame("resultsFrame");
	   opportunity.PickaccountName();
	   driver.switchTo().window(oldWindow);
	   contacts.ClickSaveAndNew();
   }
}


