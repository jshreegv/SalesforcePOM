package com.salesforce.pages.sfdclogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.salesforce.basepage.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username") WebElement email;
	@FindBy(id = "password") WebElement password;
	@FindBy(xpath = "//input[@id='Login']") WebElement login;
	@FindBy(id = "rememberUn") WebElement checkrememberme;
	@FindBy(id = "forgot_password_link") WebElement forgotpass;
	@FindBy(id = "error") WebElement error;
	@FindBy(id = "idcard-identity") WebElement idcard;
	
	public void EnterUserName(String emailId) {
		enterText(email, emailId);		
	}
	
	public void EnterPassword(String pass) {
		enterText(password, pass);
	}
	
	public void ClickLogin() {
		clickElement(login);
	}

	public void checkRememberMe() {
		clickElement(checkrememberme);
	}

	public void clickForgotPass() {
		clickElement(forgotpass);
	}
	
	public String errorText() {
		return error.getText();
	}
	
	public String getUsername() {
		return idcard.getText();
	}
	
	public void login(String userName, String password1) {
		enterText(email, userName);
		enterText(password, password1);
		clickElement(login);
	
	}
}
