package com.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.Locators;
import com.qa.hubspot.utils.TimeUtil;

public class HomePage extends BasePage {
	BasePage basePage;
	TimeUtil timeUtils;
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		timeUtils = new TimeUtil();
	}

	
	public String getHomePageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}

	public String getHomePageHeaderText() {
		tlDriver.set(driver.switchTo().frame("mainpanel"));
		if (elementUtil.doIsDisplayed(Locators.homePageHeader)) {
			return elementUtil.doGetText(Locators.homePageHeader);
		}
		return null;

	}

	public String getLoggedInUser() {
		if (elementUtil.doIsDisplayed(Locators.accountName)) {
			return elementUtil.doGetText(Locators.accountName);
		}

		return null;
	}
	
	public ContactPage gotoNewContactLink() {
		clickOnContacts();
		return new ContactPage(driver);
	}
	
	public String getLogoText() {
		return elementUtil.doGetTextString(Locators.homePageLogoText);
		
	}
	
	private void clickOnContacts() {
		//basePage.switchToFrame();
		tlDriver.set(driver.switchTo().frame("mainpanel"));
		elementUtil.mouseHover(Locators.contactsLink);
		TimeUtil.shortWait();
		elementUtil.doClick(Locators.newContactLink);
	}
	

	

}
