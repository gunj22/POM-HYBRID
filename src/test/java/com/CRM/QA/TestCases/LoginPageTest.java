package com.CRM.QA.TestCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.QA.BaseTest.BaseTest;
import com.CRM.QA.Pages.HomePage;
import com.CRM.QA.Pages.LoginPage;
import com.CRM.QA.Utils.DataUtil;

public class LoginPageTest extends BaseTest {

	public String testCaseName = "logintest";
	LoginPage logiin;
	HomePage home;

	public LoginPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException {
		openBrowser("chrome");
		navigate(prop.getProperty("url"));
		logiin = new LoginPage();

	}

	@Test(dataProvider = "getData")
	public void loginTest(Hashtable<String, String> table) throws InterruptedException, IOException {
		home = logiin.login(table.get("userName"), table.get("password"));

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = DataUtil.getTestData(xls, testCaseName);
		return data;
	}

}
