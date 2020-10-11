package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.JavaScriptUtil;

//@Listeners(ExtentReportListener.class)
public class LoginPageTest extends BaseTest {

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("This is my LoginPage Title :: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched");
	}

	@Test(priority = 1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "SignUp link is not displayed. . .");
	}

	@Test(priority = 3)

	public void verifyloginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

}
