package com.salesforce.pages.sfdclogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.salesforce.basepage.BasePage;

public class ForgotPasswordPage extends BasePage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "un") WebElement usrN;
	@FindBy(id = "continue") WebElement cont;
	
	public boolean titleChk(String title) {
		return waitUntilTitleContains(title);
	}
	
	public void enterUser(String usr) {
		enterText(usrN,usr);
	}
	
	public void clickContinue() {
		cont.click();
	}

}
