package com.CRM.QA.Pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.QA.BaseTest.BaseTest;

public class CreateContactPage extends BaseTest {

	public Select sc;

	public CreateContactPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//select[@name='title']")
//	WebElement titleDropdown;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(xpath = "//form[@id='contactForm']/child::table/descendant::input[@value='Save']")
	WebElement saveBtn;

	public void createContactsforRecord() {

				
		/*sc = new Select(titleDropdown);
		sc.selectByValue("Dr.");
*/
		firstName.sendKeys("sam");
		lastName.sendKeys("bhasin");
		click(saveBtn);

	}

}
