package com.salesforce.pages.opportunity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.basepage.BasePage;

public class OpporPage extends BasePage{

	public OpporPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "tryLexDialogX") WebElement popup;
	@FindBy(id = "fcf") WebElement view;
	@FindBy(name = "new") WebElement btnNew;
	@FindBy(xpath = "//a[contains(text(),'Opportunity Pipeline')]") WebElement oppPipeline;
	@FindBy(xpath = "//a[text()='Stuck Opportunities']") WebElement stuckOpp;
	@FindBy(id = "quarter_q") WebElement interval;
	@FindBy(id = "open") WebElement include;
	@FindBy(xpath = "//input[@value='RunReport']") WebElement runReportBtn;

	public WebElement getPopUp() {
		return popup;
	}

	public WebElement getView() {
		return view;
	}

	public WebElement getBtnNew() {
		return btnNew;
	}

	public WebElement getOppPipeline() {
		return oppPipeline;
	}

	public WebElement getStuckOpp() {
		return stuckOpp;
	}

	public void getInterval(String text) {
		selectByValueData(interval, text);
	}

	public void getInclude(String text) {
		selectByValueData(interval, text);
	}

	public WebElement getRunReportBtn() {
		return runReportBtn;
	}

	


}
