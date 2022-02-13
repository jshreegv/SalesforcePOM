package com.salesforce.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.salesforce.basetest.BaseTest;
import com.salesforce.pages.opportunity.NewOppHomePage;
import com.salesforce.pages.opportunity.OpporPage;

public class OpportunityTest extends BaseTest {
	static ITestResult result;
	
	@Test
	public void opporMenu_15() {
		try {
			OpporPage op = new OpporPage(driver);
			opporTab(op);
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());			
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	private void opporTab(OpporPage op) {
		
	}
	
	@Test
	public void createOpp_16() {
		try {
			NewOppHomePage newop= new NewOppHomePage(driver);
			OpporPage op = new OpporPage(driver);
			String accname = "abcd";
			String optname = "1234";
			opporTab(op);
			report.logTestInfo("opportunity tab clicked");
			op.clickElement(op.getBtnNew());
			Assert.assertTrue(op.waitUntilTitleContains("New Opportunity"));
			newop.enterOppName(optname);
			newop.enterAccName(accname);;
			report.logTestInfo("account selected");
			newop.getCloseDate();
			report.logTestInfo("close date selected");
			newop.clickElement(newop.getSaveBtn());
			Assert.assertTrue(newop.waitUntilTitleContains(optname));
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());			
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	@Test
	public void oppPipelineReport_17() {
		try {
			OpporPage op = new OpporPage(driver);
			opporTab(op);
			report.logTestInfo("opportunity tab clicked");
			op.clickElement(op.getOppPipeline());
			report.logTestInfo("opp pipeline clicked");			
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());			
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	@Test
	public void stuckOppReport_18() {
		try {
			OpporPage op = new OpporPage(driver);
			opporTab(op);
			report.logTestInfo("opportunity tab clicked");
			op.clickElement(op.getStuckOpp());
			report.logTestInfo("stuck opp link clicked");			
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());			
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	@Test
	public void quaterlySummaryReport_19() {
		try {
			OpporPage op = new OpporPage(driver);
			opporTab(op);
			report.logTestInfo("opportunity tab clicked");
			op.getInterval("current");
			report.logTestInfo("interval set to currentFQ");
			op.getInclude("all");
			report.logTestInfo("include all set");
			op.clickElement(op.getRunReportBtn());
			report.logTestInfo("run report clicked");
			Assert.assertTrue(op.waitUntilTitleContains("Opportunity Report"));
		} catch(Exception e) {
			report.logTestInfo(e.getMessage());			
			result.setStatus(ITestResult.FAILURE);
		}
	}
	
	private void opporTab(NewOppHomePage obj) {
		loginPage.login(username, password);
		Assert.assertTrue(homePage.waitUntilTitleContains("Home Page ~ "));
		homePage.opporTab();
		obj.clickElement(obj.getPopUp());
		Assert.assertTrue(obj.waitUntilTitleContains("Opportunities: Home"));
	}
}
