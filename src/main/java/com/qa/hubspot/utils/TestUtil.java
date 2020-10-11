package com.qa.hubspot.utils;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class TestUtil extends BasePage {

	private WebDriver driver;
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
}