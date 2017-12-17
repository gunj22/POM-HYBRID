package com.CRM.QA.TestCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.QA.BaseTest.BaseTest;
import com.CRM.QA.Pages.HomePage;
import com.CRM.QA.Pages.LoginPage;
import com.CRM.QA.Utils.DataUtil;

public class LoginPageTest extends BaseTest {

	public String testCaseName = "logintest";
	public LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void startTest() throws IOException {

		initialization("chrome");
		navigate(prop.getProperty("url"));
		loginPage = new LoginPage();

	}

	@Test(dataProvider = "getData")
	public void loginTest(Hashtable<String, String> table) throws InterruptedException, IOException {

		homepage = loginPage.login(table.get("userName"), table.get("password"));
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
