package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hubspot.pages.HomePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.TimeUtil;

public class HomePageTest extends BaseTest{
	HomePage homePage;
		
	@BeforeClass
	public void homeSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//basePage.switchToFrame();
		
	}
	
	@Test(priority = 1)
	public void  verifyHomePageTitle() {
		TimeUtil.shortWait();
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page title is :: "+title.trim());
		Assert.assertEquals(title, (Constants.HOME_PAGE_TITLE).trim(), "home page title is not matched. . . ");
	}
	
	@Test(priority = 2)
	public void  verifyHomePageHeader()   {
		
		TimeUtil.shortWait();
		String header = homePage.getHomePageHeaderText();
		System.out.println("Home Page header is :: "+ header);
		
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "home page title is not present. . .");
	}
	@Test(priority = 3)
	public void verifyLoggedInUserTest() throws InterruptedException {
		TimeUtil.shortWait();
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Logged in user name :: "+ loggedInUser.trim());
		Assert.assertEquals((loggedInUser).trim(), (prop.getProperty("accountname")), "Logged in user not matched . . .");
	}
	
	@Test(priority = 4)
	public void verifyLogoNameTest() {
		String logoName = homePage.getLogoText();
		System.out.println("Logo Name at HomePage => "+ logoName);
		Assert.assertEquals(logoName.trim(), "CRMPRO");
	}
}