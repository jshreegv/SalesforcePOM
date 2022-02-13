package com.salesforce.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.basepage.BasePage;

public class AccountPage extends BasePage{

	@FindBy(id = "tryLexDialogX") WebElement popup;
	@FindBy(xpath = "//a[contains(text(),'Accounts')]") WebElement acct;
	@FindBy(name = "new") WebElement New;
	@FindBy(name = "fcf") WebElement view;
	@FindBy(xpath = "//a[text()='Edit']") WebElement viewEdit;
	@FindBy(name = "delID") WebElement viewDelete;
	@FindBy(xpath = "//td//div[@title='Last Activity']") WebElement viewTable;
	@FindBy(xpath = "//a[contains(text(),'Merge Accounts')]") WebElement mergeAcc;
	@FindBy(xpath = "//a[contains(text(),'30 days')]") WebElement reportAct;
	@FindBy(name = "delID") WebElement deleteView;
	
	public AccountPage(WebDriver driver) {
		super(driver);
	}

	public void getPopUp() {
		if(popup.isDisplayed()) {
			popup.click();
		}
	}

	public WebElement getNew() {
		return New;
	}

	public WebElement getView() {
		return view;
	}

	public WebElement getViewEdit() {
		return viewEdit;
	}

	public WebElement getViewTable() {
		return viewTable;
	}

	public WebElement getMergeAcc() {
		return mergeAcc;
	}

	public WebElement getReportAct() {
		return reportAct;
	}

	public void deleteView(String viewName) {
		try {
			Select views = new Select(view);
			if (views.getFirstSelectedOption().getText().equals(viewName)) {
				clickElement(viewEdit);
				clickElement(viewDelete);
				AcceptAlert();
			}
		} catch (Exception e) {
			System.out.println("deleteView exception");
		}
	}	
	
	public boolean chkViewNameIn(String viewName) {
		Select views = new Select(view);
		return views.getFirstSelectedOption().getText().equalsIgnoreCase(viewName);
	}
	
	public void deleteView() {
		deleteView.click();
	}

	public void goToAccounts() {
		clickElement(acct);
	}
	
	
}
