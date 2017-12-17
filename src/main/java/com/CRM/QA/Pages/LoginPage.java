package com.CRM.QA.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.QA.BaseTest.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement passwordd;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signUpBtn;

	public LoginPage() throws IOException {
		super();

		PageFactory.initElements(driver, this);
	}

	public HomePage login(String userNamee, String password) throws InterruptedException, IOException {
		username.sendKeys(userNamee);
		passwordd.sendKeys(password);
		Thread.sleep(1000);
		loginBtn.click();
		return new HomePage();

	}

}
