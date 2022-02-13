package com.salesforce.pages.usermenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.basepage.BasePage;

public class MySettingsPage extends BasePage{

	public MySettingsPage(WebDriver driver1) {
		super(driver1);
	}

	@FindBy(xpath = "//a[@title='My Settings']") WebElement mySettings;
	@FindBy(xpath = "//span[@class='folderIcon PersonalInfo_icon']") WebElement personal;
	@FindBy(xpath = "//span[@id='LoginHistory_font']") WebElement loginHistory;
	@FindBy(xpath = "//a[contains(text(),'Download login history for last six months, includ')]") WebElement download;
	@FindBy(xpath = "//a[@href=\\\"javascript:HTMLTreeNode.prototype.toggleHTMLTree('DisplayAndLayout');\\\"]") WebElement displayLayout;
	@FindBy(xpath = "//span[@id='CustomizeTabs_font']") WebElement custMyTab;
	@FindBy(xpath = "//select[@id='p4']") WebElement custApp;
	@FindBy(xpath = "//select[@id='duel_select_0']") WebElement availableTabs;
	@FindBy(xpath = "//a[@id='duel_select_0_right']") WebElement addBtn;

	
	public void MySettings() {
		clickElement(mySettings);
	}
	
	public void moveToPersonal() {
		mouseOver(personal);
		clickElement(personal);
	}
	
	public void historyLogin() {
		clickElement(loginHistory);
	}
	
	public void downloadHistory() {
		clickElement(download);
	}
	
	public void displayAndLayout() {
		clickElement(displayLayout);
	}
	
	public void customizeTab() {
		clickElement(custMyTab);
	}
	
	public void customApp(String text) {
		selectByTextData(custApp, text);
	}
	
	public void availTabs(String text) {
		selectByTextData(availableTabs, text);
	}
	
	public void AddButton() {
		clickElement(addBtn);
	}
}
