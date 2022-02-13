package com.salesforce.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.basepage.BasePage;

public class AccViewPage extends BasePage{

	public AccViewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Create New View']") WebElement createView;
	@FindBy(id = "fname") WebElement viewName;
	@FindBy(id = "devname") WebElement uniqueViewNm;
	@FindBy(name = "save") WebElement savebtn;
	@FindBy(id = "fcol1") WebElement field;
	@FindBy(id = "fop1") WebElement operator;
	@FindBy(id = "fval1") WebElement value;
	@FindBy(id = "colselector_select_0") WebElement availableFields;
	@FindBy(id = "colselector_select_0_right") WebElement addButt;
	@FindBy(xpath = "//input[contains(@value,'Save')]") WebElement saveView;
	
	public WebElement getSaveView() {
		return saveView;
	}
	
	public void createNewView(String viewname) {
		clickElement(createView);
		viewName.clear();
		viewName.sendKeys(viewname);
		uniqueViewNm.clear();
		uniqueViewNm.sendKeys(viewname);
		clickElement(savebtn);
	}
	
	public void editView(String newviewName) {
		viewName.clear();
		uniqueViewNm.clear();
		viewName.sendKeys(newviewName);
		selectByTextData(field, "Account Name");
		selectByTextData(operator, "contains");
		value.sendKeys("a");
		if (checkOptionPresentSelect(availableFields, "Last Activity")) {
			selectByTextData(availableFields, "Last Activity");
			clickElement(addButt);
		}
	}
}
