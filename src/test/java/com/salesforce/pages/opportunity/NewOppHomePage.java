package com.salesforce.pages.opportunity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.basepage.BasePage;

public class NewOppHomePage extends BasePage {

	public NewOppHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "tryLexDialogX") WebElement popup;
	@FindBy(xpath = "//select[@id='fcf']") WebElement view;
	@FindBy(name = "new") WebElement btnNew;
	@FindBy(xpath = "//input[@id='opp3']") WebElement oppName;
	@FindBy(xpath = "//input[@id='opp4']") WebElement accName;
	@FindBy(xpath = "//a[normalize-space()='1/28/2022']") WebElement closeDate;
	@FindBy(xpath = "//select[@id='opp11']") WebElement stage;
	@FindBy(xpath = "//input[@id='opp12']") WebElement prabability;
	@FindBy(xpath = "//select[@id='opp6']") WebElement leadSource;
	@FindBy(xpath = "//input[@id='opp17']") WebElement priCampaign;
	@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Save']") WebElement saveBtn;
	
	
	public WebElement getPopUp() {
		return popup;
	}
	public WebElement getView() {
		return view;
	}
	public WebElement getBtnNew() {
		return btnNew;
	}
	public void enterOppName(String name) {
		enterText(oppName, name);
	}
	public void enterAccName(String name) {
		enterText(accName, name);
	}
	public WebElement getCloseDate() {
		return closeDate;
	}
	public WebElement getStage() {
		return stage;
	}
	public WebElement getPrabability() {
		return prabability;
	}
	public WebElement getLeadSource() {
		return leadSource;
	}
	public WebElement getPriCampaign() {
		return priCampaign;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}	
	
}
