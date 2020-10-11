package com.hubspot.pages;

import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.JavaScriptUtil;
import com.qa.hubspot.utils.Locators;

public class LoginPage extends BasePage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	// Page Action

	public String getLoginPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}

	public boolean verifySignUpLink() {
		return elementUtil.doIsDisplayed(Locators.loginUsername);

	}

	public HomePage doLogin(String username, String password) {

		elementUtil.waitForElementToBePresent(Locators.loginUsername, 10);

		elementUtil.doSendKeys(Locators.loginUsername, username);
		elementUtil.doSendKeys(Locators.loginPassword, password);
		elementUtil.doClick(Locators.loginButton);

		return new HomePage(driver);
	}

}
