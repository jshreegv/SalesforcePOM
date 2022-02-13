package com.salesforce.pages.usermenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.basepage.BasePage;

public class MyProfilePage extends BasePage {
	
	
	public MyProfilePage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath = "//a[normalize-space()='My Profile']") WebElement myprofile;
    @FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]") WebElement editProfile;
    @FindBy(id = "contactInfoContent") WebElement edit;
    @FindBy(xpath = "//a[contains(text(),'About')]") WebElement aboutTab;
    @FindBy(xpath = "//input[@id='lastName']") WebElement lName;
    @FindBy(xpath = "//input[@value='Save All']") WebElement saveAll;
    @FindBy(xpath = "//span[normalize-space()='Post']") WebElement post;
    @FindBy(xpath = "//body") WebElement postTxt;
    @FindBy(xpath = "//input[@id='publishersharebutton']") WebElement shareButton;
    @FindBy(xpath = "//span[normalize-space()='File']") WebElement file;
	
    
    public void Myprofile() {
    	clickElement(myprofile);
    	getTitle();
	}
       
	public void EditProfile() {
		clickElement(editProfile);
		switchToFrameByName(edit);
	}
	
	public void AboutTab() {
		clickElement(aboutTab);		
	}

	public void lName(String name) {
		enterText(lName, name);
	}
	public String getLname() {
		return lName.getText();
	}
	
	public void SaveAll() {
		 clickElement(saveAll);
	}
	
	public void Post() {
		 clickElement(post);
	}
	
	public void PostTxt(String text) {
		clickElement(postTxt);
		enterText(postTxt, text);
	}
	
	public void ShareButton() {
		clickElement(shareButton);
	}
	
	public WebElement getFile() {
		return file;
	}
    
    
    
    
}
