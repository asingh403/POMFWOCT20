package com.qa.hubspot.utils;

import org.openqa.selenium.By;

public class Locators {

	// ****** Login page Locators *****************/

	public static final By loginUsername = By.xpath("//input[@name = 'username']");
	public static final By loginPassword = By.xpath("//input[@name = 'password']");
	public static final By loginButton = By.xpath("//input[@type = 'submit']");
	public static final By loginSignUpLink = By.linkText("Sign Up");
	public static final By logoDisplayed = By.className("navbar-brand");
	

	// ****** Home Page Locators *****************/
	public static final By accountName = By.xpath("//td[contains(text(), 'User: Demo User ')]");
	public static final By homePageHeader = By.xpath("//*[contains(text(), 'Free account ::')]");

	public static final By contactsLink = By.xpath("//a[contains(text(), 'Contacts')]");  
	public static final By newContactLink = By.xpath("//a[contains(text(), 'New Contact')]");
	public static final By homePageLogoText = By.className("logo_text");

	// ************ New Contact Page Locators ************

	public static final By firstName = By.id("first_name");
	public static final By lastName = By.id("surname");
	public static final By msngrID = By.id("im_id");
	public static final By contactPageInfo = By.xpath("//*[contains(text(), 'Contact Information')]");
	public static final By saveBtn = By.xpath("//input[@type='submit' and @value = 'Save']");
	public static final By addressTitle = By.xpath("//*[contains(text(), 'Address Title')]");
	public static final By altEmailText = By.xpath("//*[contains(text(), 'Email (alt.)')]");
	

}
