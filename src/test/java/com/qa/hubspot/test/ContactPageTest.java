package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hubspot.pages.ContactPage;
import com.hubspot.pages.HomePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;
import com.qa.hubspot.utils.TimeUtil;

public class ContactPageTest extends BaseTest {

	HomePage homePage;
	ContactPage contactsPage;

	@BeforeClass
	public void contactSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.gotoNewContactLink();
	}

	@Test(priority = 1)
	public void verifyContactPageInfoTest() {
		String pageInfo = contactsPage.getContactPageInfo();
		System.out.println("Contact Page Header :: " + pageInfo);
		Assert.assertEquals(pageInfo, Constants.CONTACT_PAGE_INFO);
	}

	@Test(priority = 2)
	public void verifyAddressTitleTextTest() {
		String adderessTitleText = contactsPage.getAddressTitleText();
		Assert.assertEquals(adderessTitleText, Constants.ADDERSS_TITLE_TEXT);
	}

	@Test(priority = 3)
	public void verifyAltEmailTextTest() {
		String altEmailText = contactsPage.getAltEmailText();
		Assert.assertEquals(altEmailText, Constants.ALT_EMAIL_TEXT);
	}

	@Test(priority = 5, dataProvider = "getContactsTestData", enabled = false)
	public void verifyCreateContactNoTest(String firstName, String lastName, String msengrID) {
		contactsPage.createContactWithMoreThanMandatory(firstName, lastName, msengrID);
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object[][] data = ExcelUtil.getTestData(Constants.CONTACT_SHEET_NAME);
		System.out.println(data.toString());

		return data;
	}

	@Test(priority = 4)
	public void verifyCreateContactWithMandatoryDetailTest() {

		TimeUtil.shortWait();
		contactsPage.createContactWithMandatoryDetail("Shree", "Singh1");
		Assert.assertEquals("Shree Singh1", contactsPage.afterCreateContact());
	}
}
