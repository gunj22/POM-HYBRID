package com.CRM.QA.TestCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.QA.BaseTest.BaseTest;
import com.CRM.QA.Pages.CreateContactPage;
import com.CRM.QA.Pages.HomePage;
import com.CRM.QA.Pages.LoginPage;
import com.CRM.QA.Utils.DataUtil;

public class CreateContactTest extends BaseTest {

	public HomePage home;
	public LoginPage login;
	public CreateContactPage contact;
	String testCaseName = "createContactsTest";

	public CreateContactTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void startTest() throws InterruptedException, IOException {
		openBrowser("chrome");
		navigate(prop.getProperty("url"));
		contact = new CreateContactPage();
		login = new LoginPage();
		home = login.login(prop.getProperty("username"), prop.getProperty("pwd"));

	}

	@Test(dataProvider = "getdata")
	public void saveNewContactRecord(Hashtable<String, String> table) throws InterruptedException, IOException {
		home.contactTest();
		contact.createContactsforRecord();
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = DataUtil.getTestData(xls, testCaseName);
		return data;

	}

}
