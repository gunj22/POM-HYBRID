package com.CRM.QA.TestCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.QA.BaseTest.BaseTest;
import com.CRM.QA.Pages.HomePage;
import com.CRM.QA.Pages.LoginPage;
import com.CRM.QA.Utils.DataUtil;

public class HomePageTest extends BaseTest {

	String testCaseName = "logintest";
	HomePage home;
	LoginPage login;

	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void startTest() throws IOException, InterruptedException {

		openBrowser("chrome");
		navigate(prop.getProperty("url"));
		login = new LoginPage();
		home = login.login(prop.getProperty("username"), prop.getProperty("pwd"));

	}

	@Test(dataProvider = "getData")
	public void createContactTest(Hashtable<String, String> table) throws InterruptedException, IOException {

		home.contactTest();

	}

	@DataProvider
	public Object[][] getData() {

		return DataUtil.getTestData(xls, testCaseName);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
