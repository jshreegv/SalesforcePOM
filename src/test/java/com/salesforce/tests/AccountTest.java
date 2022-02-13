package com.salesforce.tests;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.salesforce.basetest.BaseTest;
import com.salesforce.pages.account.AccViewPage;
import com.salesforce.pages.account.AccountPage;

public class AccountTest extends BaseTest{
	static ITestResult result;

	public void CreateAccount_10() {
		try {
			String accName = "salesforce";
			AccountPage acc = new AccountPage(driver);
			acc.goToAccounts();
			acc.getNew();
			report.logTestInfo("new clicked");
						
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	@Test
	public void CreateNewView_11() {
		try {
			String viewNm = "salesaccount";
			AccountPage acc = new AccountPage(driver);
			AccViewPage accView = new AccViewPage(driver);
			acc.goToAccounts();
			acc.getPopUp();
			if (acc.checkOptionPresentSelect(acc.getView(), viewNm)) {
				acc.clickElement(acc.getViewEdit());
				acc.deleteView();
			}
			accView.createNewView(viewNm);
			accView.editView(viewNm);
			report.logTestInfo("new view created");
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
	}
}
