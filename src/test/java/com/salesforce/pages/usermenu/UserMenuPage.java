package com.salesforce.pages.usermenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.basepage.BasePage;

public class UserMenuPage extends BasePage {

	@FindBy(xpath ="//span[@id='userNavLabel']") WebElement usermenu;
	@FindBy(id = "userNav-arrow") WebElement usermenudrop;
	@FindBy(id = "userNav-menuItems") WebElement usermenuoptions;
	
	public UserMenuPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickUserMenu() {
		clickElement(usermenu);
	}
	
	public String getDropDownMenu() {
		return usermenuoptions.getText();
	}

}
