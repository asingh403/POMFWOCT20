package com.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.Locators;
import com.qa.hubspot.utils.TimeUtil;

public class ContactPage extends BasePage {

	private WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getContactPageInfo() {
		elementUtil.mouseHoverClick(Locators.contactsLink, Locators.newContactLink);
		String name = elementUtil.doGetTextString(Locators.contactPageInfo);
		return name;
	}

	public void createContactWithMoreThanMandatory(String firstName, String lastName, String msngrId) {

		elementUtil.doSendKeys(Locators.firstName, firstName);
		elementUtil.doSendKeys(Locators.lastName, lastName);
		elementUtil.doSendKeys(Locators.msngrID, msngrId);
		
		elementUtil.clickWhenReady(Locators.saveBtn, 5);
		elementUtil.mouseHoverClick(Locators.contactsLink, Locators.newContactLink);

	}

	public String afterCreateContact() {
		TimeUtil.shortWait();
		String fullName = elementUtil.doGetTextFnameLname(Locators.firstName, Locators.lastName);
		return fullName;
	}
	
	public String getAddressTitleText() {
		return elementUtil.doGetTextString(Locators.addressTitle);
		
	}
	
	public String getAltEmailText() {
		return elementUtil.doGetTextString(Locators.altEmailText);
	}

	public void createContactWithMandatoryDetail(String firstName, String lastName) {
		elementUtil.mouseHoverClick(Locators.contactsLink, Locators.newContactLink);
		elementUtil.doSendKeys(Locators.firstName, firstName);
		elementUtil.doSendKeys(Locators.lastName, lastName);
		elementUtil.doClick(Locators.saveBtn);
	}

}
